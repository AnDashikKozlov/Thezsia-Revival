package Thezsia.world.meta;

import mindustry.world.meta.Env;

/** Environmental flags for different types of locations. */
public class ThezEnv extends Env {
    public static final int
    /* Underwater but for my mod. A bit different color. */
    underwaterWarm = 1 << 14,
    darkness = 1 << 15;
}