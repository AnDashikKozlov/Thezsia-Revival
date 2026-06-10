package Thezsia.core;

import arc.Core;
import arc.struct.Seq;
import mindustry.entities.units.BuildPlan;

import java.util.*;

import static mindustry.Vars.*;

public class ThezVars {
    /** Placement plans stored for wire bridging. DO NOT MODIFY! */
    public static Seq<BuildPlan> wirePlans = new Seq<>();

    /** If true will hide some effects, like little smoke from cracked floor or magma. */
    public static boolean  settingsLowDetail = Core.settings.getBool("@settings.lowdetail");

    /** Testing / Debug mode. If True will give user access to any planet, etc. */
    public static boolean  settingsDebug = Core.settings.getBool("@settings.debug");
}
