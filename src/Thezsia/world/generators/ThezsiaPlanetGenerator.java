package Thezsia.world.generators;

import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.util.Tmp;
import arc.util.noise.*;
import mindustry.content.Blocks;
import mindustry.maps.generators.PlanetGenerator;
import mindustry.world.Block;

import static Thezsia.content.Thezsia.blocks.ThezEnv.*;

public class ThezsiaPlanetGenerator extends PlanetGenerator {
    public float heightScl = 1.2f, octaves = 4, persistence = 1.2f, heightPow = 1.0f, heightMult = 0.8f;

    @Override
    public float getHeight(Vec3 position){
        return Mathf.pow(rawHeight(position), heightPow) * heightMult;
    }

    float rawHeight(Vec3 position){
        return Simplex.noise3d(seed, octaves, persistence, 1f/heightScl, 10f + position.x, 10f + position.y, 10f + position.z);
    }

    @Override
    public Color getColor(Vec3 position){
        Block block = rawHeight(position) < 0.3f ? Blocks.water : rawHeight(position) < 0.7f ? peridotite : rawHeight(position) < 0.65f ? peridotiteDark : rawHeight(position) < 0.47f ? hardCharrok : rawHeight(position) < 0.5f ? charrokFloor : rawHeight(position) < 0.35f ? basalticPatch : rawHeight(position) < 0.9f ? sulfurFloor : Blocks.ferricStone;
        return Tmp.c1.set(block.mapColor).a(1f - block.albedo);
    }
}