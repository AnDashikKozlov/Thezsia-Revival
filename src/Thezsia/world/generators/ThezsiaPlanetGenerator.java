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
// PlanetDialog.debugSelect = true
public class ThezsiaPlanetGenerator extends PlanetGenerator {
    public float heightScl = 0.74f, octaves = 8, persistence = 0.6f, heightPow = 2.7f, heightMult = 1.42f;

    public static float arkThresh = 0.26f, arkScl = 0.85f;
    public static int arkSeed = 6, arkOct = 3;
    public static float redThresh = 2.9f, noArkThresh = 0.36f;
    public static int sulfurSeed = 8, sulfurOct = 1;
    public static float sulfurScl = 0.02f, sulfurMag = 0.007f;

    Block[] terrain = {ThezsiaEnv.charrokWall, ThezsiaEnv.peridotiteWall, ThezsiaEnv.basalticWall, ThezsiaEnv.charrokWall, ThezsiaEnv.basalticWall, ThezsiaEnv.basalticWall, ThezsiaEnv.charrokWall, ThezsiaEnv.charrokWall, ThezsiaEnv.hardCharrokWall, ThezsiaEnv.hardCharrokWall, ThezsiaEnv.igneousBasalticWall, ThezsiaEnv.igneousBasalticWall, ThezsiaEnv.magmaticWall, ThezsiaEnv.hotRockWall};

    @Override
    public float getHeight(Vec3 position){
        return Mathf.pow(rawHeight(position), heightPow) * heightMult;
    }

    float rawHeight(Vec3 position){
        return Simplex.noise3d(seed, octaves, persistence, 1f/heightScl, 10f + position.x, 10f + position.y, 10f + position.z);
    }
    /*
    @Override
    public void getColor(Vec3 position){
        Block block = rawHeight(position) < 0.4f ? Blocks.slag : rawHeight(position) < 0.5f ? Blocks.regolith : rawHeight(position) < 0.6f ? Blocks.basalt : Blocks.redIce;
        return Tmp.c1.set(block.mapColor).a(1f - block.albedo);
    }
    */
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
        // /*
        if(ice < 0.3f + Math.abs(Ridged.noise3d(seed + sulfurSeed, position.x + 5f, position.y + 5f, position.z + 0.2f, sulfurOct, sulfurScl)) * sulfurMag){
            return ThezsiaEnv.sulfurWall;
        }else if(ice > redThresh - 0.2){
            result = ThezsiaEnv.basalticWall;
        }
        // */
        if(ice < 0.7){
            if(result == ThezsiaEnv.basalticWall){
                return ThezsiaEnv.basalticWall;
            }
        }

        position = Tmp.v32;

        if(ice < redThresh - noArkThresh && Ridged.noise3d(seed + arkSeed, position.x + 2f, position.y + 8f, position.z + 1f, arkOct, arkScl) > arkThresh){
            result = ThezsiaEnv.basalticWall;
        }

        if(ice > redThresh){
            result = ThezsiaEnv.peridotiteWall;
        }else if(ice > redThresh - 0.52f){
            result = ThezsiaEnv.basalticWall;
        }else if(ice > redThresh - 0.2f) {
            result = ThezsiaEnv.darkPeridotiteWall;
        }else if(ice > redThresh - 0.07f) {
            result = ThezsiaEnv.sulfurWall;
        }

        return result;
    }
}