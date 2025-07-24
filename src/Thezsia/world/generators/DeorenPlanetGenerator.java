package Thezsia.world.generators;

import Thezsia.content.Thezsia.blocks.ThezsiaEnv;
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

    public static float arkThresh = 0.26f, arkScl = 0.84f;
    public static int arkSeed = 6, arkOct = 2;
    public static float redThresh = 2.8f, noArkThresh = 0.35f;
    public static int regolithSeed = 5, regolithOct = 1;
    public static float regolithScl = 0.18f, regolithMag = 0.006f;

    Block[] terrain = {Blocks.slag, ThezsiaEnv.magmaticWall, ThezsiaEnv.hotRockWall, ThezsiaEnv.igneousBasalticWall, ThezsiaEnv.hardCharrokWall, ThezsiaEnv.igneousBasalticWall, ThezsiaEnv.charrokWall, ThezsiaEnv.basalticWall, ThezsiaEnv.hotRockWall, ThezsiaEnv.igneousBasalticWall, ThezsiaEnv.basalticWall, ThezsiaEnv.basalticWall, ThezsiaEnv.igneousBasalticWall, ThezsiaEnv.hotRockWall};

    @Override
    public float getHeight(Vec3 position){
        return Mathf.pow(rawHeight(position), heightPow) * heightMult;
    }

    float rawHeight(Vec3 position){
        return Simplex.noise3d(seed, octaves, persistence, 1f/heightScl, 10f + position.x, 10f + position.y, 10f + position.z);
    }

    /*@Override
    public void getColor(Vec3 position){
        Block block = rawHeight(position) < 0.4f ? Blocks.slag : rawHeight(position) < 0.5f ? Blocks.regolith : rawHeight(position) < 0.6f ? Blocks.basalt : Blocks.redIce;
        return Tmp.c1.set(block.mapColor).a(1f - block.albedo);
    }*/


    @Override
    public void getColor(Vec3 position, Color out) {
        Block block = getBlock(position);
        out.set(block.mapColor).a(1f - block.albedo);
    }

    float rawTemp(Vec3 position){
        return position.dst(0, 0, 1)*2.2f - Simplex.noise3d(seed, 8, 0.54f, 1.4f, 10f + position.x, 10f + position.y, 10f + position.z) * 2.9f;
    }

    Block getBlock(Vec3 position){
        float ice = rawTemp(position);
        Tmp.v32.set(position);

        float height = rawHeight(position);
        Tmp.v31.set(position);
        height *= 1.3f;
        height = Mathf.clamp(height);

        Block result = terrain[Mathf.clamp((int)(height * terrain.length), 0, terrain.length - 1)];

        if(ice < 0.3 + Math.abs(Ridged.noise3d(seed + regolithSeed, position.x + 4f, position.y + 5f, position.z + 0.5f, regolithOct, regolithScl)) * regolithMag){
            return Blocks.regolithWall;
        }

        if(ice < 0.8){
            if(result == ThezsiaEnv.basalticWall){
                return ThezsiaEnv.basalticWall;
            }
        }

        position = Tmp.v32;

        if(ice < redThresh - noArkThresh && Ridged.noise3d(seed + arkSeed, position.x + 2f, position.y + 8f, position.z + 1f, arkOct, arkScl) > arkThresh){
            result = ThezsiaEnv.basalticWall;
        }

        if(ice > redThresh){
            result = Blocks.crystallineStoneWall;
        }else if(ice > redThresh - 0.4){
            result = Blocks.graphiticWall;
        }else if(ice > redThresh - 0.6) {
            result = Blocks.carbonWall;
        }

        return result;
    }
}