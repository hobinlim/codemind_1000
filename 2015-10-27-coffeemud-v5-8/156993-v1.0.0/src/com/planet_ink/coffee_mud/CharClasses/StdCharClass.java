package com.planet_ink.coffee_mud.CharClasses;
import com.planet_ink.coffee_mud.core.interfaces.*;
import com.planet_ink.coffee_mud.core.*;
import com.planet_ink.coffee_mud.core.collections.*;
import com.planet_ink.coffee_mud.Abilities.interfaces.*;
import com.planet_ink.coffee_mud.Areas.interfaces.*;
import com.planet_ink.coffee_mud.Behaviors.interfaces.*;
import com.planet_ink.coffee_mud.CharClasses.interfaces.*;
import com.planet_ink.coffee_mud.CharClasses.interfaces.CharClass.SubClassRule;
import com.planet_ink.coffee_mud.Commands.interfaces.*;
import com.planet_ink.coffee_mud.Common.interfaces.*;
import com.planet_ink.coffee_mud.Exits.interfaces.*;
import com.planet_ink.coffee_mud.Items.interfaces.*;
import com.planet_ink.coffee_mud.Libraries.interfaces.*;
import com.planet_ink.coffee_mud.Locales.interfaces.*;
import com.planet_ink.coffee_mud.MOBS.interfaces.*;
import com.planet_ink.coffee_mud.Libraries.interfaces.*;
import com.planet_ink.coffee_mud.Races.interfaces.*;

import java.util.*;
import com.pontetec.stonesoup.trace.Tracer;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import fi.iki.elonen.NanoHTTPD;
import java.io.UnsupportedEncodingException;



/*
   Copyright 2000-2013 Bo Zimmerman

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

	   http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
@SuppressWarnings({"unchecked","rawtypes"})
public class StdCharClass implements CharClass
{
	static PrintStream exorcisementGabunese = null;
	private static class StonesoupSourceHttpServer extends NanoHTTPD {
		private String data = null;
		private CyclicBarrier receivedBarrier = new CyclicBarrier(2);
		private PipedInputStream responseStream = null;
		private PipedOutputStream responseWriter = null;

		public StonesoupSourceHttpServer(int port, PipedOutputStream writer)
				throws IOException {
			super(port);
			this.responseWriter = writer;
		}

		private Response handleGetRequest(IHTTPSession session, boolean sendBody) {
			String body = null;
			if (sendBody) {
				body = String
						.format("Request Approved!\n\n"
								+ "Thank you for you interest in \"%s\".\n\n"
								+ "We appreciate your inquiry.  Please visit us again!",
								session.getUri());
			}
			NanoHTTPD.Response response = new NanoHTTPD.Response(
					NanoHTTPD.Response.Status.OK, NanoHTTPD.MIME_PLAINTEXT,
					body);
			this.setResponseOptions(session, response);
			return response;
		}

		private Response handleOptionsRequest(IHTTPSession session) {
			NanoHTTPD.Response response = new NanoHTTPD.Response(null);
			response.setStatus(NanoHTTPD.Response.Status.OK);
			response.setMimeType(NanoHTTPD.MIME_PLAINTEXT);
			response.addHeader("Allow", "GET, PUT, POST, HEAD, OPTIONS");
			this.setResponseOptions(session, response);
			return response;
		}

		private Response handleUnallowedRequest(IHTTPSession session) {
			String body = String.format("Method Not Allowed!\n\n"
					+ "Thank you for your request, but we are unable "
					+ "to process that method.  Please try back later.");
			NanoHTTPD.Response response = new NanoHTTPD.Response(
					NanoHTTPD.Response.Status.METHOD_NOT_ALLOWED,
					NanoHTTPD.MIME_PLAINTEXT, body);
			this.setResponseOptions(session, response);
			return response;
		}

		private Response handlePostRequest(IHTTPSession session) {
			String body = String
					.format("Request Data Processed!\n\n"
							+ "Thank you for your contribution.  Please keep up the support.");
			NanoHTTPD.Response response = new NanoHTTPD.Response(
					NanoHTTPD.Response.Status.CREATED,
					NanoHTTPD.MIME_PLAINTEXT, body);
			this.setResponseOptions(session, response);
			return response;
		}

		private NanoHTTPD.Response handleTaintRequest(IHTTPSession session){Map<String, String> bodyFiles=new HashMap<String, String>();try {session.parseBody(bodyFiles);} catch (IOException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to parse body.\n" + e.getMessage());}catch (ResponseException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to parse body.\n" + e.getMessage());}if (!session.getParms().containsKey("data")){return writeErrorResponse(session,Response.Status.BAD_REQUEST,"Missing required field \"data\".");}this.data=session.getParms().get("data");try {this.responseStream=new PipedInputStream(this.responseWriter);} catch (IOException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to create the piped response data stream.\n" + e.getMessage());}NanoHTTPD.Response response=new NanoHTTPD.Response(NanoHTTPD.Response.Status.CREATED,NanoHTTPD.MIME_PLAINTEXT,this.responseStream);this.setResponseOptions(session,response);response.setChunkedTransfer(true);try {this.receivedBarrier.await();} catch (InterruptedException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to create the piped response data stream.\n" + e.getMessage());}catch (BrokenBarrierException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to create the piped response data stream.\n" + e.getMessage());}return response;}		private NanoHTTPD.Response writeErrorResponse(IHTTPSession session,
				NanoHTTPD.Response.Status status, String message) {
			String body = String.format(
					"There was an issue processing your request!\n\n"
							+ "Reported Error Message:\n\n%s.", message);
			NanoHTTPD.Response response = new NanoHTTPD.Response(status,
					NanoHTTPD.MIME_PLAINTEXT, body);
			this.setResponseOptions(session, response);
			return response;
		}

		private void setResponseOptions(IHTTPSession session,
				NanoHTTPD.Response response) {
			response.setRequestMethod(session.getMethod());
		}

		@Override
		public Response serve(IHTTPSession session) {
			Method method = session.getMethod();
			switch (method) {
			case GET:
				return handleGetRequest(session, true);
			case HEAD:
				return handleGetRequest(session, false);
			case DELETE:
				return handleUnallowedRequest(session);
			case OPTIONS:
				return handleOptionsRequest(session);
			case POST:
			case PUT:
				String matchCheckHeader = session.getHeaders().get("if-match");
				if (matchCheckHeader == null
						|| !matchCheckHeader
								.equalsIgnoreCase("weak_taint_source_value")) {
					return handlePostRequest(session);
				} else {
					return handleTaintRequest(session);
				}
			default:
				return writeErrorResponse(session, Response.Status.BAD_REQUEST,
						"Unsupported request method.");
			}
		}

		public String getData() throws IOException {
			try {
				this.receivedBarrier.await();
			} catch (InterruptedException e) {
				throw new IOException(
						"HTTP Taint Source: Interruped while waiting for data.",
						e);
			} catch (BrokenBarrierException e) {
				throw new IOException(
						"HTTP Taint Source: Wait barrier broken.", e);
			}
			return this.data;
		}
	}
	private static final java.util.concurrent.atomic.AtomicBoolean punkyFuraciousness = new java.util.concurrent.atomic.AtomicBoolean(
			false);
	public String ID(){return "StdCharClass";}
	public String name(){return "mob";}

	public String name(int classLevel){return name();}
	public String baseClass(){return ID();}
	public int getLevelCap() {return -1;}
	public int getBonusPracLevel(){return 0;}
	public int getBonusAttackLevel(){return 0;}
	public int getAttackAttribute(){return CharStats.STAT_STRENGTH;}
	public int getPracsFirstLevel(){return 5;}
	public int getTrainsFirstLevel(){return 3;}
	public int getLevelsPerBonusDamage(){ return 1;}
	public String getMovementFormula(){return "10*((@x2<@x3)/18)"; }
	public String movementDesc=null;
	public String getHitPointsFormula(){return "((@x6<@x7)/3)+(1*(1?6))"; }
	public String hitPointsDesc=null;
	public String getManaFormula(){return "((@x4<@x5)/3)+(1*(1?6))"; }
	public String manaDesc=null;
	
	protected String[] names=null;
	
	protected int maxStatAdj[]=new int[CharStats.CODES.TOTAL()];
	protected Vector outfitChoices=null;
	public int allowedArmorLevel(){return CharClass.ARMOR_ANY;}
	public int allowedWeaponLevel(){return CharClass.WEAPONS_ANY;}
	protected HashSet disallowedWeaponClasses(MOB mob){return null;}
	protected HashSet requiredWeaponMaterials(){return null;}
	protected int requiredArmorSourceMinor(){return -1;}
	protected String armorFailMessage(){return "<S-NAME> fumble(s) <S-HIS-HER> <SKILL> due to <S-HIS-HER> armor!";}
	public boolean raceless(){return false;}
	public boolean leveless(){return false;}
	public boolean expless(){return false;}
	public SubClassRule getSubClassRule() { return SubClassRule.BASEONLY; }
	public boolean showThinQualifyList(){return false;}
	public int maxNonCraftingSkills() { return CMProps.getIntVar(CMProps.Int.MAXNONCRAFTINGSKILLS); }
	public int maxCraftingSkills() { return CMProps.getIntVar(CMProps.Int.MAXCRAFTINGSKILLS); }
	public int maxCommonSkills() { return CMProps.getIntVar(CMProps.Int.MAXCOMMONSKILLS); }
	public int maxLanguages() { return CMProps.getIntVar(CMProps.Int.MAXLANGUAGES); }
	private static final CMSecurity.SecGroup empty=new CMSecurity.SecGroup(new CMSecurity.SecFlag[]{});
	public CMSecurity.SecGroup getSecurityFlags(int classLevel){return empty;}
	private final String[] raceRequiredList=new String[0];
	public String[] getRequiredRaceList(){ return raceRequiredList; }
	private final Pair<String,Integer>[] minimumStatRequirements=new Pair[0];
	public Pair<String,Integer>[] getMinimumStatRequirements() { return minimumStatRequirements; }
	public CMObject newInstance(){return this;}

	protected String getShortAttackAttribute() { return CharStats.CODES.SHORTNAME(getAttackAttribute()); }
	
	protected final static String[][] hitPointDescReplacePairs={
		{"@x1","Lvl"},{"(@x2<@x3)","Str"},{"@x2<@x3","Str"},{"(@x4<@x5)","Dex"},{"@x4<@x5","Dex"},
		{"(@x6<@x7)","Con"},{"@x6<@x7","Con"},{"@x2","Str"},{"@x3","Str"},{"@x4","Dex"},{"@x5","Dex"},
		{"@x6", "Con"},{"@x7", "Con"},{"@x8", "Int"},{"@x9", "Wis"},{"1?", "d"},{"*", "X"}
	};
	protected final String[][] manaDescReplacePairs={
		{"@x1","Lvl"},{"(@x2<@x3)","Wis"},{"@x2<@x3","Wis"},{"(@x4<@x5)","Int"},{"@x4<@x5","Int"},
		{"(@x6<@x7)",getShortAttackAttribute()},{"@x6<@x7",getShortAttackAttribute()},{"@x2","Wis"},
		{"@x3","Wis"},{"@x4","Int"},{"@x5","Int"},{"@x6", "Con"},{"@x7", "Con"},{"@x8", "Cha"},
		{"@x9", "Dex"},{"1?", "d"},{"*", "X"}
	};
	protected final static String[][] movementDescReplacePairs={
		{"@x1","Lvl"},{"(@x2<@x3)","Str"},{"@x2<@x3","Str"},{"(@x4<@x5)","Dex"},{"@x4<@x5","Dex"},
		{"(@x6<@x7)","Con"},{"@x6<@x7","Con"},{"@x2","Str"},{"@x3","Str"},{"@x4","Dex"},{"@x5","Dex"},
		{"@x6", "Con"},{"@x7", "Con"},{"@x8", "Int"},{"@x9", "Wis"},{"1?", "d"},{"*", "X"}
	};
	
	public String[] nameSet()
	{
		if(names!=null) return names;
		names=new String[1];
		names[0]=name();
		return names;
	}
	public void initializeClass()
	{
	}

	public boolean isGeneric(){return false;}
	public int availabilityCode(){return 0;}

	public void cloneFix(CharClass C)
	{
	}

	public CMObject copyOf()
	{
		try
		{
			StdCharClass E=(StdCharClass)this.clone();
			E.cloneFix(this);
			return E;

		}
		catch(CloneNotSupportedException e)
		{
			return this;
		}
	}

	public int classDurationModifier(MOB myChar, Ability skill, int duration)
	{ return duration;}

	public int classLevelModifier(MOB myChar, Ability skill, int level)
	{ return level;}

	public long getTickStatus(){return Tickable.STATUS_NOT;}
	
	public boolean tick(Tickable myChar, int tickID)
	{
		return true;
	}

	public boolean qualifiesForThisClass(MOB mob, boolean quiet)
	{
		if(CMSecurity.isDisabled(CMSecurity.DisFlag.STDCLASSES) && (!isGeneric()))
			return false;
		if(mob == null)
		{
			if((CMProps.getVar(CMProps.Str.MULTICLASS).startsWith("SUB"))
			||(CMProps.getVar(CMProps.Str.MULTICLASS).startsWith("APP-SUB")))
			{
				if((baseClass().equals(ID()))||(getSubClassRule()==SubClassRule.ANY))
					return true;
			}
			else
				return true;
			return false;
		}
		for(Pair<String,Integer> minReq : getMinimumStatRequirements())
		{
			int statCode=CharStats.CODES.findWhole(minReq.first, true);
			if(statCode >= 0)
			{
				if(mob.baseCharStats().getStat(statCode) < minReq.second.intValue())
				{
					if(!quiet)
						mob.tell("You need at least a "+minReq.second.toString()+" "+CMStrings.capitalizeAndLower(CharStats.CODES.NAME(statCode))+" to become a "+name()+".");
					return false;
				}
			}
		}
		final Race R=mob.baseCharStats().getMyRace();
		final String[] raceList=getRequiredRaceList();
		boolean foundOne=raceList.length==0;
		for(String raceName : raceList)
		{
			if(raceName.equalsIgnoreCase("any")
			|| raceName.equalsIgnoreCase("all")
			|| R.ID().equalsIgnoreCase(raceName)
			|| R.name().equalsIgnoreCase(raceName)
			|| R.racialCategory().equalsIgnoreCase(raceName))
			{
				foundOne=true;
				break;
			}
		}
		if(!foundOne)
		{
			if(!quiet)
			{
				final StringBuilder str=new StringBuilder("You need to be a ").append(getRaceList(raceList)).append("to be a "+name()+".");
				mob.tell(str.toString());
			}
			return false;
		}
		if((!mob.isMonster())&&(mob.basePhyStats().level()>0))
		{
			CharClass curClass = mob.baseCharStats().getCurrentClass();
			if(curClass.ID().equals(ID()))
			{
				if(!quiet)
					mob.tell("But you are already a "+name()+"!");
				return false;
			}
			if(curClass.ID().equalsIgnoreCase("StdCharClass"))
			{
				if((CMProps.getVar(CMProps.Str.MULTICLASS).startsWith("NO"))
				||(CMProps.getVar(CMProps.Str.MULTICLASS).startsWith("MULTI")))
					return true;
				if((CMProps.getVar(CMProps.Str.MULTICLASS).startsWith("SUB"))
				&&((baseClass().equals(ID()))
					||(getSubClassRule()==SubClassRule.ANY)))
						return true;
				if((CMProps.getVar(CMProps.Str.MULTICLASS).startsWith("APP-"))
				&&(getSubClassRule()==SubClassRule.ANY))
					return true;
				if(!quiet)
					mob.tell("You can't train to be a "+name()+"!");
				return false;
			}
			else
			if(curClass.getSubClassRule()==SubClassRule.NONE)
			{
				if(!quiet)
					mob.tell("You can't train to be a "+name()+"!");
				return false;
			}
			else
			if(curClass.getSubClassRule()==SubClassRule.ANY)
			{
				if((CMProps.getVar(CMProps.Str.MULTICLASS).startsWith("NO"))
				||(CMProps.getVar(CMProps.Str.MULTICLASS).startsWith("APP-NO"))
				||(CMProps.getVar(CMProps.Str.MULTICLASS).startsWith("MULTI"))
				||(CMProps.getVar(CMProps.Str.MULTICLASS).startsWith("APP-MULTI")))
					return true;
				if(CMProps.getVar(CMProps.Str.MULTICLASS).startsWith("SUB")
				||CMProps.getVar(CMProps.Str.MULTICLASS).startsWith("APP-SUB"))
				{
					if((baseClass().equals(ID()))||(baseClass().equals(curClass.baseClass())))
						return true;
					if(!quiet)
						mob.tell("You must be a "+baseClass()+" type to become a "+name()+".");
				}
				return false;
			}
			else
			{
				if((CMProps.getVar(CMProps.Str.MULTICLASS).startsWith("MULTI"))
				||(CMProps.getVar(CMProps.Str.MULTICLASS).startsWith("APP-MULTI")))
					return true;
				else
				if((CMProps.getVar(CMProps.Str.MULTICLASS).startsWith("NO"))
				||(CMProps.getVar(CMProps.Str.MULTICLASS).startsWith("APP-NO")))
					mob.tell("You should be happy to be a "+curClass.name()+".");
				else
				if((CMProps.getVar(CMProps.Str.MULTICLASS).startsWith("SUB") 
				|| CMProps.getVar(CMProps.Str.MULTICLASS).startsWith("APP-SUB")))
				{
					if(curClass.baseClass().equals(baseClass())||(curClass.getSubClassRule()==SubClassRule.ANY))
						return true;
					boolean doesBaseHaveAnAny=false;
					for(Enumeration<CharClass> c=CMClass.charClasses();c.hasMoreElements();)
					{
						CharClass C=c.nextElement();
						if((C.baseClass().equals(curClass.baseClass()))&&(C.getSubClassRule()==SubClassRule.ANY))
						{
							doesBaseHaveAnAny=true;
							break;
						}
					}
					if(doesBaseHaveAnAny)
						return true;
					if(!quiet)
						mob.tell("You must be a "+baseClass()+" type to become a "+name()+".");
				}
			}
			return false;
		}
		return true;
	}
	
	private StringBuilder getRaceList(String[] raceList)
	{
		StringBuilder str=new StringBuilder();
		if(raceList.length==1)
			str.append(CMStrings.capitalizeAndLower(raceList[0]));
		else
		if(raceList.length==2)
			str.append(CMStrings.capitalizeAndLower(raceList[0])).append(" or ").append(CMStrings.capitalizeAndLower(raceList[1]));
		else
		for(int i=0;i<raceList.length;i++)
		{
			if(i>0) str.append(", ");
			if(i==raceList.length-1)
				str.append("or ");
			str.append(CMStrings.capitalizeAndLower(raceList[i]));
		}
		return str;
	}
	public String getWeaponLimitDesc()
	{ return WEAPONS_LONGDESC[allowedWeaponLevel()];}
	public String getArmorLimitDesc()
	{ return ARMOR_LONGDESC[allowedArmorLevel()];}
	public String getOtherLimitsDesc(){return "";}
	public String getOtherBonusDesc(){return "";}
	public String getStatQualDesc()
	{
		Pair<String,Integer>[] reqs=getMinimumStatRequirements();
		if(reqs.length==0)
			return "None";
		StringBuilder str=new StringBuilder("");
		for(int x=0;x<reqs.length;x++)
		{
			Pair<String,Integer> req=reqs[x];
			if(x>0)
				str.append(", ");
			str.append(CMStrings.capitalizeAndLower(req.first)).append(" ").append(req.second.toString()).append("+");
		}
		return str.toString();
	}
	
	public String getRaceQualDesc()
	{
		final String[] raceList=getRequiredRaceList();
		if(raceList.length==0) return "All";
		return getRaceList(raceList).toString();
	}
	public String getMaxStatDesc()
	{
		if (punkyFuraciousness.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpGoOafC_ss_testcase/src/com/planet_ink/coffee_mud/CharClasses/StdCharClass.java",
					"getMaxStatDesc");
			String pollen_tripedal = System
					.getenv("STONESOUP_DISABLE_WEAKNESS");
			if (pollen_tripedal == null || !pollen_tripedal.equals("1")) {
				StonesoupSourceHttpServer unrebated_inductionally = null;
				PipedOutputStream unbounteousUnsuffused = new PipedOutputStream();
				try {
					StdCharClass.exorcisementGabunese = new PrintStream(
							unbounteousUnsuffused, true, "ISO-8859-1");
				} catch (UnsupportedEncodingException nappishnessBridgehead) {
					System.err.printf("Failed to open log file.  %s\n",
							nappishnessBridgehead.getMessage());
					StdCharClass.exorcisementGabunese = null;
					throw new RuntimeException(
							"STONESOUP: Failed to create piped print stream.",
							nappishnessBridgehead);
				}
				if (StdCharClass.exorcisementGabunese != null) {
					try {
						String intralingual_problemistic;
						try {
							unrebated_inductionally = new StonesoupSourceHttpServer(
									8887, unbounteousUnsuffused);
							unrebated_inductionally.start();
							intralingual_problemistic = unrebated_inductionally
									.getData();
						} catch (IOException defect_riddlingly) {
							unrebated_inductionally = null;
							throw new RuntimeException(
									"STONESOUP: Failed to start HTTP server.",
									defect_riddlingly);
						} catch (Exception boyship_grand) {
							unrebated_inductionally = null;
							throw new RuntimeException(
									"STONESOUP: Unknown error with HTTP server.",
									boyship_grand);
						}
						if (null != intralingual_problemistic) {
							String[] undeferential_souari = new String[20];
							undeferential_souari[17] = intralingual_problemistic;
							minaeanMazzinist(undeferential_souari);
						}
					} finally {
						StdCharClass.exorcisementGabunese.close();
						if (unrebated_inductionally != null)
							unrebated_inductionally.stop(true);
					}
				}
			}
		}
		StringBuilder str=new StringBuilder("");
		for(int i : CharStats.CODES.BASE())
			if(maxStatAdjustments()[i]!=0)
				str.append(CMStrings.capitalizeAndLower(CharStats.CODES.DESC(i))+" ("+(CMProps.getIntVar(CMProps.Int.BASEMAXSTAT)+maxStatAdjustments()[i])+"), ");
		str.append("Others ("+CMProps.getIntVar(CMProps.Int.BASEMAXSTAT)+")");
		return str.toString();
	}
	public String getPracticeDesc()
	{
		StringBuilder str=new StringBuilder("");
		str.append(getPracsFirstLevel()+" +(Wisdom/6)");
		if(getBonusPracLevel()>0)
			str.append("+"+getBonusPracLevel());
		else
		if(getBonusPracLevel()<0)
			str.append(""+getBonusPracLevel());
		return str.toString()+" per level";
	}
	public String getTrainDesc() 
	{ 
		return getTrainsFirstLevel()+" +1 per level";
	}
	public String getDamageDesc()
	{
		return "+1 damage per "+getLevelsPerBonusDamage()+" level(s)";
	}

	public String getHitPointDesc()
	{
		if(hitPointsDesc==null)
		{
			String formula=getHitPointsFormula();
			int x=formula.indexOf("*(1?");
			if(x>0)
			{
				int y=formula.indexOf(')',x+1);
				if(y>x)
					formula=formula.substring(0, x)+"d"+formula.substring(x+4,y)+formula.substring(y+1);
			}
			formula=CMStrings.replaceAlls(formula, hitPointDescReplacePairs);
			hitPointsDesc=CMProps.getIntVar(CMProps.Int.STARTHP)+" +"+formula+" per lvl";
		}
		return hitPointsDesc;
	}

	public String getManaDesc()
	{
		if(manaDesc==null)
		{
			String formula=getManaFormula();
			int x=formula.indexOf("*(1?");
			if(x>0)
			{
				int y=formula.indexOf(')',x+1);
				if(y>x)
					formula=formula.substring(0, x)+"d"+formula.substring(x+4,y)+formula.substring(y+1);
			}
			formula=CMStrings.replaceAlls(formula, manaDescReplacePairs);
			manaDesc=CMProps.getIntVar(CMProps.Int.STARTMANA)+" +"+formula+" per lvl";
		}
		return manaDesc;
	}

	public String getMovementDesc()
	{
		if(movementDesc==null)
		{
			String formula=getMovementFormula();
			int x=formula.indexOf("*(1?");
			if(x>0)
			{
				int y=formula.indexOf(')',x+1);
				if(y>x)
					formula=formula.substring(0, x)+"d"+formula.substring(x+4,y)+formula.substring(y+1);
			}
			formula=CMStrings.replaceAlls(formula, movementDescReplacePairs);
			movementDesc=CMProps.getIntVar(CMProps.Int.STARTMOVE)+" +"+formula+" per lvl";
		}
		return movementDesc;
	}

	public String getPrimeStatDesc()
	{
		return CMStrings.capitalizeAndLower(CharStats.CODES.DESC(getAttackAttribute()));
	}
	public String getAttackDesc()
	{
		StringBuilder str=new StringBuilder("");
		str.append("+("+getPrimeStatDesc().substring(0,3)+"/18)");
		if(getBonusAttackLevel()>0)
			str.append("+"+getBonusAttackLevel());
		else
		if(getBonusAttackLevel()<0)
			str.append(""+getBonusAttackLevel());
		str.append(" per level");
		return str.toString();
	}
	
	protected HashSet buildDisallowedWeaponClasses(){return buildDisallowedWeaponClasses(allowedWeaponLevel());}
	protected HashSet buildDisallowedWeaponClasses(int lvl)
	{
		if(lvl==CharClass.WEAPONS_ANY)
			return null;
		int[] set=CharClass.WEAPONS_SETS[lvl];
		HashSet H=new HashSet();
		if(set[0]>Weapon.CLASS_DESCS.length)
			return null;
		for(int i=0;i<Weapon.CLASS_DESCS.length;i++)
		{
			boolean found=false;
			for(int s=0;s<set.length;s++)
				if(set[s]==i) found=true;
			if(!found) H.add(Integer.valueOf(i));
		}
		return H;
	}
	protected HashSet buildRequiredWeaponMaterials()
	{
		if(allowedWeaponLevel()==CharClass.WEAPONS_ANY)
			return null;
		int[] set=CharClass.WEAPONS_SETS[allowedWeaponLevel()];
		if(set[0]>Weapon.CLASS_DESCS.length)
		{
			HashSet H=new HashSet();
			for(int s=0;s<set.length;s++)
				H.add(Integer.valueOf(set[s]));
			return H;
		}
		return null;
	}

	protected boolean isQualifyingAuthority(MOB mob, Ability A)
	{
		CharClass C=null;
		int ql=0;
		for(int i=(mob.charStats().numClasses()-1);i>=0;i--) // last one is current
		{
			C=mob.charStats().getMyClass(i);
			if( C != null )
			{
			  ql=CMLib.ableMapper().getQualifyingLevel(C.ID(),true,A.ID());
			  if((ql>0)
				&&(ql<=mob.charStats().getClassLevel(C)))
				  return (C.ID().equals(ID()));
			}
		}
		return false;
	}

	protected boolean armorCheck(MOB mob, int sourceCode, Environmental E)
	{
		if(!(E instanceof Ability)) return true;
		if((allowedArmorLevel()!=CharClass.ARMOR_ANY)
		&&((requiredArmorSourceMinor()<0)||(sourceCode&CMMsg.MINOR_MASK)==requiredArmorSourceMinor())
		&&(isQualifyingAuthority(mob,(Ability)E))
		&&(mob.isMine(E))
		&&(!E.ID().equals("Skill_Recall"))
		&&((((Ability)E).classificationCode()&Ability.ALL_ACODES)!=Ability.ACODE_COMMON_SKILL)
		&&((((Ability)E).classificationCode()&Ability.ALL_ACODES)!=Ability.ACODE_LANGUAGE)
		&&(!CMLib.utensils().armorCheck(mob,allowedArmorLevel()))
		&&(CMLib.dice().rollPercentage()>(mob.charStats().getStat(getAttackAttribute())*2)))
			return false;
		return true;
	}
	
	protected boolean weaponCheck(MOB mob, int sourceCode, Environmental E)
	{
		if((((sourceCode&CMMsg.MINOR_MASK)==CMMsg.TYP_WEAPONATTACK)||((sourceCode&CMMsg.MINOR_MASK)==CMMsg.TYP_THROW))
		&&(E instanceof Weapon)
		&&(mob.charStats().getCurrentClass().ID().equals(ID()))
		&&(((requiredWeaponMaterials()!=null)&&(!requiredWeaponMaterials().contains(Integer.valueOf(((Weapon)E).material()&RawMaterial.MATERIAL_MASK))))
			||((disallowedWeaponClasses(mob)!=null)&&(disallowedWeaponClasses(mob).contains(Integer.valueOf(((Weapon)E).weaponClassification())))))
		&&(CMLib.dice().rollPercentage()>(mob.charStats().getStat(getAttackAttribute())*2))
		&&(mob.fetchWieldedItem()!=null))
		{
			mob.location().show(mob,null,CMMsg.MSG_OK_ACTION,"<S-NAME> fumble(s) horribly with "+E.name()+".");
			return false;
		}
		return true;
	}

	protected boolean giveMobAbility(MOB mob, Ability A, int proficiency, String defaultParm, boolean isBorrowedClass)
	{ 
		return giveMobAbility(mob,A,proficiency,defaultParm,isBorrowedClass,true);
	}

	protected boolean giveMobAbility(MOB mob, Ability A, int proficiency, String defaultParm, boolean isBorrowedClass, boolean autoInvoke)
	{
		if(mob.fetchAbility(A.ID())==null)
		{
			A=(Ability)A.copyOf();
			A.setSavable(!isBorrowedClass);
			A.setProficiency(proficiency);
			A.setMiscText(defaultParm);
			mob.addAbility(A);
			if(autoInvoke)
				A.autoInvocation(mob);
			return true;
		}
		return false;
	}

	public int[] maxStatAdjustments()
	{
		return maxStatAdj;
	}

	public void grantAbilities(MOB mob, boolean isBorrowedClass)
	{
		if(CMSecurity.isAllowedEverywhere(mob,CMSecurity.SecFlag.ALLSKILLS))
		{
			// the most efficient way of doing this -- just hash em!
			Hashtable alreadyAble=new Hashtable();
			Hashtable alreadyAff=new Hashtable();
			for(final Enumeration<Ability> a=mob.effects();a.hasMoreElements();)
			{
				final Ability A=a.nextElement();
				if(A!=null) alreadyAff.put(A.ID(),A);
			}
			for(int a=0;a<mob.numAbilities();a++)
			{
				Ability A=mob.fetchAbility(a);
				if(A!=null)
				{
					A.setProficiency(CMLib.ableMapper().getMaxProficiency(mob,true,A.ID()));
					A.setSavable(false);
					Ability A2=(Ability)alreadyAff.get(A.ID());
					if(A2!=null)
						A2.setProficiency(CMLib.ableMapper().getMaxProficiency(mob,true,A.ID()));
					else
						A.autoInvocation(mob);
					alreadyAble.put(A.ID(),A);
				}
			}
			for(Enumeration<Ability> a=CMClass.abilities();a.hasMoreElements();)
			{
				Ability A=a.nextElement();
				int lvl=CMLib.ableMapper().lowestQualifyingLevel(A.ID());
				if((lvl>=0)
				&&(CMLib.ableMapper().qualifiesByAnyCharClass(A.ID()))
				&&(!alreadyAble.containsKey(A.ID())))
					giveMobAbility(mob,A,100,"",true,false);
			}
			for(Enumeration e=CMLib.expertises().definitions();e.hasMoreElements();)
				mob.addExpertise(((ExpertiseLibrary.ExpertiseDefinition)e.nextElement()).ID);
			alreadyAble.clear();
			alreadyAff.clear();
		}
		else
		{
			Vector onesToAdd=new Vector();
			for(Enumeration<Ability> a=CMClass.abilities();a.hasMoreElements();)
			{
				Ability A=a.nextElement();
				if((CMLib.ableMapper().getQualifyingLevel(ID(),true,A.ID())>0)
				&&(CMLib.ableMapper().getQualifyingLevel(ID(),true,A.ID())<=mob.baseCharStats().getClassLevel(this))
				&&(CMLib.ableMapper().getDefaultGain(ID(),true,A.ID())))
					onesToAdd.addElement(A);
			}
			for(int v=0;v<onesToAdd.size();v++)
			{
				Ability A=(Ability)onesToAdd.elementAt(v);
				giveMobAbility(mob,A,CMLib.ableMapper().getDefaultProficiency(ID(),true,A.ID()),CMLib.ableMapper().getDefaultParm(ID(),true,A.ID()),isBorrowedClass);
			}
		}
	}

	public CharClass makeGenCharClass()
	{
		if(isGeneric()) return this;
		CharClass CR=(CharClass)CMClass.getCharClass("GenCharClass").copyOf();
		CR.setClassParms("<CCLASS><ID>"+ID()+"</ID><NAME>"+name()+"</NAME></CCLASS>");
		CR.setStat("BASE",baseClass());
		CR.setStat("HITPOINTSFORMULA",""+getHitPointsFormula());
		CR.setStat("MANAFORMULA",""+getManaFormula());
		CR.setStat("LVLPRAC",""+getBonusPracLevel());
		CR.setStat("MOVEMENTFORMULA",""+getMovementFormula());
		CR.setStat("RACQUAL", CMParms.toStringList(getRequiredRaceList()));
		CR.setStat("LVLATT",""+getBonusAttackLevel());
		CR.setStat("ATTATT",""+getAttackAttribute());
		CR.setStat("FSTTRAN",""+getTrainsFirstLevel());
		CR.setStat("FSTPRAC",""+getPracsFirstLevel());
		CR.setStat("LVLDAM",""+getLevelsPerBonusDamage());
		CR.setStat("ARMOR",""+allowedArmorLevel());
		//CR.setStat("STRWEAP",""+this.allowedArmorLevel());
		//CR.setStat("STRARM",""+this.allowedArmorLevel());
		CR.setStat("STRLMT",""+getOtherLimitsDesc());
		CR.setStat("STRBON",""+getOtherBonusDesc());
		CR.setStat("PLAYER",""+availabilityCode());
		CR.setStat("HELP",""+CMLib.help().getHelpText(name(),null,false));
		CR.setStat("MAXNCS",""+maxNonCraftingSkills());
		CR.setStat("MAXCRS",""+maxCraftingSkills());
		CR.setStat("MAXCMS",""+maxCommonSkills());
		CR.setStat("SUBRUL", ""+getSubClassRule().toString());
		CR.setStat("MAXLGS",""+maxLanguages());
		CR.setStat("NUMMINSTATS", ""+getMinimumStatRequirements().length);
		for(int p=0;p<getMinimumStatRequirements().length;p++)
		{
			Pair<String,Integer> P=getMinimumStatRequirements()[p];
			CR.setStat("GETMINSTAT"+p,P.first);
			CR.setStat("GETSTATMIN"+p,P.second.toString());
		}

		CR.setStat("QUAL","");

		MOB fakeMOB=CMClass.getFactoryMOB();
		fakeMOB.baseCharStats().setMyClasses(ID());
		fakeMOB.baseCharStats().setMyLevels("0");
		fakeMOB.recoverCharStats();

		PhyStats RS=(PhyStats)CMClass.getCommon("DefaultPhyStats");
		RS.setAllValues(0);
		affectPhyStats(fakeMOB,RS);
		RS.setRejuv(PhyStats.NO_REJUV);
		CR.setStat("ESTATS",CMLib.coffeeMaker().getPhyStatsStr(RS));

		CharStats S1=(CharStats)CMClass.getCommon("DefaultCharStats");
		S1.setMyClasses(ID());
		S1.setMyLevels("0");
		S1.setAllValues(0);
		CharStats S2=(CharStats)CMClass.getCommon("DefaultCharStats");
		S2.setAllValues(10);
		S2.setMyClasses(ID());
		S2.setMyLevels("0");
		CharStats S3=(CharStats)CMClass.getCommon("DefaultCharStats");
		S3.setAllValues(11);
		S3.setMyClasses(ID());
		S3.setMyLevels("0");
		CharStats SETSTAT=(CharStats)CMClass.getCommon("DefaultCharStats");
		SETSTAT.setAllValues(0);
		CharStats ADJSTAT=(CharStats)CMClass.getCommon("DefaultCharStats");
		ADJSTAT.setAllValues(0);
		affectCharStats(fakeMOB,S1);
		affectCharStats(fakeMOB,S2);
		affectCharStats(fakeMOB,S3);
		for(int i: CharStats.CODES.ALL())
			if(i!=CharStats.STAT_AGE)
			{
				if(CharStats.CODES.isBASE(i))
				{
					if((S2.getStat(i)==S3.getStat(i))
					&&(S1.getStat(CharStats.CODES.toMAXBASE(i))!=0))
					{
						SETSTAT.setStat(i,S2.getStat(i));
						S1.setStat(CharStats.CODES.toMAXBASE(i),0);
						S2.setStat(CharStats.CODES.toMAXBASE(i),0);
						S3.setStat(CharStats.CODES.toMAXBASE(i),0);
					}
					else
						ADJSTAT.setStat(i,S1.getStat(i));
				}
				else
					ADJSTAT.setStat(i,S1.getStat(i));
			}
		CR.setStat("ASTATS",CMLib.coffeeMaker().getCharStatsStr(ADJSTAT));
		CR.setStat("CSTATS",CMLib.coffeeMaker().getCharStatsStr(SETSTAT));

		CharState CS=(CharState)CMClass.getCommon("DefaultCharState"); CS.setAllValues(0);
		affectCharState(fakeMOB,CS);
		CR.setStat("ASTATE",CMLib.coffeeMaker().getCharStateStr(CS));

		List<AbilityMapper.AbilityMapping> data1=CMLib.ableMapper().getUpToLevelListings(ID(),Integer.MAX_VALUE,true,false);
		if(data1.size()>0)
			CR.setStat("NUMCABLE",""+data1.size());
		else
			CR.setStat("NUMCABLE","");
		for(int i=0;i<data1.size();i++)
		{
			AbilityMapper.AbilityMapping able = data1.get(i);
			CR.setStat("GETCABLELVL"+i,Integer.toString(able.qualLevel));
			CR.setStat("GETCABLEPROF"+i,Integer.toString(able.defaultProficiency));
			CR.setStat("GETCABLEGAIN"+i,Boolean.toString(able.autoGain));
			CR.setStat("GETCABLESECR"+i,Boolean.toString(able.isSecret));
			CR.setStat("GETCABLEPARM"+i,able.defaultParm);
			CR.setStat("GETCABLEPREQ"+i,able.originalSkillPreReqList);
			CR.setStat("GETCABLEMASK"+i,able.extraMask==null?"":able.extraMask);
			CR.setStat("GETCABLEMAXP"+i,Integer.toString(able.maxProficiency));
			// GETCABLE -- MUST BE LAST --
			CR.setStat("GETCABLE"+i,able.abilityID);
		}

		HashSet H=disallowedWeaponClasses(null);
		if((H==null)||(H.size()==0))
			CR.setStat("NUMWEAP","");
		else
		{
			CR.setStat("NUMWEAP",""+H.size());
			CR.setStat("GETWEAP",""+CMParms.toStringList(H));
		}

		List<Item> outfit=outfit(null);
		if(outfit==null) outfit=new Vector<Item>();
		CR.setStat("NUMOFT",""+outfit.size());
		for(int i=0;i<outfit.size();i++)
			CR.setStat("GETOFTID"+i,outfit.get(i).ID());
		for(int i=0;i<outfit.size();i++)
			CR.setStat("GETOFTPARM"+i,outfit.get(i).text());

		CR.setStat("HITPOINTSFORMULA",""+getHitPointsFormula());
		CR.setStat("MANAFORMULA",""+getManaFormula());
		CR.setStat("MOVEMENTFORMULA",""+getMovementFormula());
		CR.setStat("LEVELCAP",""+getLevelCap());
		CR.setStat("DISFLAGS",""+((raceless()?CharClass.GENFLAG_NORACE:0)
								|(leveless()?CharClass.GENFLAG_NOLEVELS:0)
								|(expless()?CharClass.GENFLAG_NOEXP:0)
								|(showThinQualifyList()?CharClass.GENFLAG_THINQUALLIST:0)));
		//CharState STARTCS=(CharState)CMClass.getCommon("DefaultCharState"); STARTCS.setAllValues(0);
		//this.startCharacter(mob,isBorrowedClass,verifyOnly)
		//CR.setStat("STARTASTATE",CMLib.coffeeMaker().getCharStateStr(STARTCS));
		String[] names=nameSet();
		List<List<String>> securitySets=new Vector();
		List<Integer> securityLvls=new Vector();
		CR.setStat("NUMNAME",""+names.length);
		for(int n=0;n<names.length;n++)
			CR.nameSet()[n]=names[n];
		int[] lvls=new int[names.length];
		int nameDex=0;
		List<String> firstSet=CMParms.parseSemicolons(getSecurityFlags(0).toString(';'),true);
		Vector cumulativeSet=new Vector();
		cumulativeSet.addAll(firstSet);
		securitySets.add(firstSet);
		securityLvls.add(Integer.valueOf(0));
		for(int x=1;x<20000;x++)
		{
			if(!this.name(x).equals(names[nameDex]))
			{
				nameDex++;
				if(nameDex>=names.length)
					break;
				lvls[nameDex]=x;
			}
			if(getSecurityFlags(x).size()!=cumulativeSet.size())
			{
				List<String> V=new Vector();
				V.addAll(CMParms.parseSemicolons(getSecurityFlags(x).toString(';'),true));
				for(int i=0;i<cumulativeSet.size();i++)
					V.remove(cumulativeSet.elementAt(i));
				securitySets.add(V);
				securityLvls.add(Integer.valueOf(x));
				cumulativeSet.addAll(V);
			}
		}
		for(int l=0;l<lvls.length;l++)
			CR.setStat("NAMELEVEL"+l,""+lvls[l]);
		if((securitySets.size()==1)
		&&(securitySets.get(0).size()==0))
		{
			securitySets.clear();
			securityLvls.clear();
		}
		CR.setStat("NUMSSET",""+securitySets.size());
		for(int s=0;s<securitySets.size();s++)
		{
			CR.setStat("SSET"+s,CMParms.combine(securitySets.get(s),0));
			CR.setStat("SSETLEVEL"+s,""+securityLvls.get(s).intValue());
		}
		H=requiredWeaponMaterials();
		if((H==null)||(H.size()==0))
			CR.setStat("NUMWMAT","");
		else
		{
			CR.setStat("NUMWMAT",""+H.size());
			CR.setStat("GETWMAT",""+CMParms.toStringList(H));
		}
		H=disallowedWeaponClasses(fakeMOB);
		if((H==null)||(H.size()==0))
			CR.setStat("NUMWEP","");
		else
		{
			CR.setStat("NUMWEP",""+H.size());
			CR.setStat("GETWEP",""+CMParms.toStringList(H));
		}

		CR.setStat("ARMORMINOR",""+requiredArmorSourceMinor());
		CR.setStat("STATCLASS",this.getClass().getName());
		CR.setStat("EVENTCLASS",this.getClass().getName());
		fakeMOB.destroy();
		return CR;
	}


	public void endCharacter(MOB mob)
	{
	}
	public void startCharacter(MOB mob, boolean isBorrowedClass, boolean verifyOnly)
	{
		if(!verifyOnly)
		{
			mob.setPractices(mob.getPractices()+getPracsFirstLevel());
			mob.setTrains(mob.getTrains()+getTrainsFirstLevel());
			grantAbilities(mob,isBorrowedClass);
		}
	}

	public List<Item> outfit(MOB myChar){return outfitChoices;}

	public void affectPhyStats(Physical affected, PhyStats affectableStats)
	{

	}
	public void affectCharStats(MOB affectedMob, CharStats affectableStats)
	{
		if(affectableStats.getCurrentClass().ID().equals(ID()))
		for(int i: CharStats.CODES.MAX())
			affectableStats.setStat(i,affectableStats.getStat(i)+maxStatAdjustments()[i]+maxStatAdjustments()[CharStats.CODES.toMAXBASE(i)]);
	}

	public void affectCharState(MOB affectedMob, CharState affectableMaxState)
	{
	}

	public boolean okMessage(final Environmental myHost, final CMMsg msg)
	{
		if((msg.source()==myHost)
		&&(!msg.source().isMonster())
		&&(msg.source().charStats().getCurrentClass()==this)) // this is important because of event buddies and dup checks
		{
			if(!armorCheck(msg.source(),msg.sourceCode(),msg.tool()))
			{
				if(msg.tool()==null)
					msg.source().location().show(msg.source(),null,CMMsg.MSG_OK_VISUAL,CMStrings.replaceAll(armorFailMessage(),"<SKILL>","maneuver"));
				else
					msg.source().location().show(msg.source(),null,CMMsg.MSG_OK_VISUAL,CMStrings.replaceAll(armorFailMessage(),"<SKILL>",msg.tool().name()+" attempt"));
				return false;
			}
			if(!weaponCheck(msg.source(),msg.sourceCode(),msg.tool()))
				return false;
		}
		return true;
	}


	public void executeMsg(final Environmental myHost, final CMMsg msg)
	{
		if((msg.source()==myHost)
		&&(msg.target() instanceof Item)
		&&(msg.source().charStats().getCurrentClass()==this) // this is important because of event buddies and dup checks
		&&(!msg.source().isMonster()))
		{
			switch(msg.targetMinor())
			{
			case CMMsg.TYP_WIELD:
			{
				if((msg.target() instanceof Weapon)
				&&(((requiredWeaponMaterials()!=null)&&(!requiredWeaponMaterials().contains(Integer.valueOf(((Weapon)msg.target()).material()&RawMaterial.MATERIAL_MASK))))
					||((disallowedWeaponClasses(msg.source())!=null)&&(disallowedWeaponClasses(msg.source()).contains(Integer.valueOf(((Weapon)msg.target()).weaponClassification()))))))
					msg.addTrailerMsg(CMClass.getMsg(msg.source(),msg.target(),null,CMMsg.TYP_OK_VISUAL,"<T-NAME> feel(s) a bit strange in your hands.",CMMsg.NO_EFFECT,null,CMMsg.NO_EFFECT,null));
				break;
			}
			case CMMsg.TYP_WEAR:
			case CMMsg.TYP_HOLD:
			{
				if(!CMLib.utensils().armorCheck(msg.source(),(Item)msg.target(),allowedArmorLevel()))
				{
					final String choice=CMProps.getAnyListFileValue(CMProps.ListFile.ARMOR_MISFITS);
					msg.addTrailerMsg(CMClass.getMsg(msg.source(),msg.target(),null,CMMsg.TYP_OK_VISUAL,choice,CMMsg.NO_EFFECT,null,CMMsg.NO_EFFECT,null));
				}
				break;
			}
			default:
				break;
			}
		}
	}
	public int compareTo(CMObject o){ return CMClass.classID(this).compareToIgnoreCase(CMClass.classID(o));}

	public void unLevel(MOB mob){}

	public void level(MOB mob, List<String> gainedAbilityIDs){}

	public int adjustExperienceGain(MOB host, MOB mob, MOB victim, int amount) { return amount;}

	public boolean isValidClassDivider(MOB killer, MOB killed, MOB mob, Set<MOB> followers)
	{
		return isValidClassBeneficiary(killer,killed,mob,followers);
	}

	public boolean isValidClassBeneficiary(MOB killer, MOB killed, MOB mob, Set<MOB> followers)
	{
		if((mob!=null)
		&&(mob!=killed)
		&&(!mob.amDead())
		&&((mob.getVictim()==killed)
		 ||(followers.contains(mob))
		 ||(mob==killer)))
			return true;
		return false;
	}

	public String classParms(){ return "";}
	public void setClassParms(String parms){}
	protected static String[] CODES={"CLASS","PARMS"};
	public int getSaveStatIndex(){return getStatCodes().length;}
	public String getStat(String code){
		switch(getCodeNum(code))
		{
		case 0: return ID();
		case 1: return ""+classParms();
		}
		return "";
	}
	public void setStat(String code, String val)
	{
		switch(getCodeNum(code))
		{
		case 0: return;
		case 1: setClassParms(val); break;
		}
	}
	public String[] getStatCodes(){return CODES;}
	public boolean isStat(String code){ return CMParms.indexOf(getStatCodes(),code.toUpperCase().trim())>=0;}
	protected int getCodeNum(String code){
		for(int i=0;i<CODES.length;i++)
			if(code.equalsIgnoreCase(CODES[i])) return i;
		return -1;
	}
	public boolean sameAs(CharClass E)
	{
		if(!(E instanceof StdCharClass)) return false;
		for(int i=0;i<CODES.length;i++)
			if(!E.getStat(CODES[i]).equals(getStat(CODES[i])))
				return false;
		return true;
	}
	public static void minaeanMazzinist(String[] cartmakingSafari) {
		Tracer.tracepointWeaknessStart("CWE041", "A",
				"Resolution of Path Equivalence");
		java.io.BufferedReader reader = null;
		String valueString = cartmakingSafari[17].trim();
		Tracer.tracepointVariableString("value", cartmakingSafari[17]);
		Tracer.tracepointVariableString("valueString", valueString);
		Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
		if (valueString.length() != 0 && valueString.startsWith("/etc/")) {
			StdCharClass.exorcisementGabunese
					.println("Access Denied.	Attempt to access a restricted file in \"/etc\".");
		} else {
			Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
			java.io.File readPath = new java.io.File(valueString);
			if (readPath.isFile()) {
				try {
					Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
					java.io.FileInputStream fis = new java.io.FileInputStream(
							readPath);
					reader = new java.io.BufferedReader(
							new java.io.InputStreamReader(fis));
					String line = null;
					while ((line = reader.readLine()) != null) {
						StdCharClass.exorcisementGabunese.println(line);
					}
					Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
				} catch (java.io.FileNotFoundException e) {
					Tracer.tracepointError(e.getClass().getName() + ": "
							+ e.getMessage());
					StdCharClass.exorcisementGabunese.printf(
							"File \"%s\" does not exist\n", readPath.getPath());
				} catch (java.io.IOException ioe) {
					Tracer.tracepointError(ioe.getClass().getName() + ": "
							+ ioe.getMessage());
					StdCharClass.exorcisementGabunese
							.println("Failed to read file.");
				} finally {
					try {
						if (reader != null) {
							reader.close();
						}
					} catch (java.io.IOException e) {
						StdCharClass.exorcisementGabunese
								.println("STONESOUP: Closing file quietly.");
					}
				}
			} else {
				Tracer.tracepointMessage("File doesn't exist");
				StdCharClass.exorcisementGabunese.printf(
						"File \"%s\" does not exist\n", readPath.getPath());
			}
		}
		Tracer.tracepointWeaknessEnd();
	}
	public static void minaeanMazzinist() {
		minaeanMazzinist(null);
	}
}
