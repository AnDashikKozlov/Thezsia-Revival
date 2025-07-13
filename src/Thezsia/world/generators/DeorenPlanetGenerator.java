package Thezsia.world.generators;

import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.util.Tmp;
import arc.util.noise.*;
import mindustry.content.Blocks;
import mindustry.maps.generators.PlanetGenerator;
import mindustry.world.Block;

public class DeorenPlanetGenerator extends PlanetGenerator {
    public float heightScl = 1.4f, octaves = 5, persistence = 0.8f, heightPow = 2.4f, heightMult = 1.1f;

    @Override
    public float getHeight(Vec3 position){
        return Mathf.pow(rawHeight(position), heightPow) * heightMult;
    }

    float rawHeight(Vec3 position){
        return Simplex.noise3d(seed, octaves, persistence, 1f/heightScl, 10f + position.x, 10f + position.y, 10f + position.z);
    }

    @Override
    public Color getColor(Vec3 position){
        Block block = rawHeight(position) < 0.4f ? Blocks.slag : rawHeight(position) < 0.5f ? Blocks.regolith : rawHeight(position) < 0.6f ? Blocks.basalt : Blocks.redIce;
        return Tmp.c1.set(block.mapColor).a(1f - block.albedo);
    }
}