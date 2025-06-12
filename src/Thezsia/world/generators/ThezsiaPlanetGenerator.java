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
    public float heightScl = 1.0f, octaves = 4, persistence = 0.8f, heightPow = 1.3f, heightMult = 1.15f;

    @Override
    public float getHeight(Vec3 position){
        return Mathf.pow(rawHeight(position), heightPow) * heightMult;
    }

    float rawHeight(Vec3 position){
        return Simplex.noise3d(seed, octaves, persistence, 1f/heightScl, 10f + position.x, 10f + position.y, 10f + position.z);
    }

    @Override
    public Color getColor(Vec3 position){
        Block block = rawHeight(position) < 0.3f ? Blocks.slag : rawHeight(position) < 0.62f ? peridotite : rawHeight(position) < 0.64f ? peridotiteDark : rawHeight(position) < 0.4f ? hardCharrok : rawHeight(position) < 0.47f ? charrokFloor : rawHeight(position) < 0.55f ? basalticPatch : rawHeight(position) < 0.45f ? sulfurFloor : Blocks.ferricStone;
        return Tmp.c1.set(block.mapColor).a(1f - block.albedo);
    }
}