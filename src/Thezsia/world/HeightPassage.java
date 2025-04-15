package Thezsia.Thezworld;

import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.noise.*;

public abstract class HeightPassage {

    //code from omaloon:3
    public abstract float height(Vec3 pos, float height);

    public boolean valid(Vec3 pos, float height){
        return true;
    }

    public static class SphereHeight extends HeightPassage{

         //Position of the sphere relative to the planet.

        public Vec3 pos = new Vec3();

        //Radius of the sphere.

        public float radius = 0f;

        // Height offset applied inside the sphere

        public float offset = 0f;

        //When true, this pass will set the current height to the offset instead of increasing the height by the offset.

        public boolean set = false;

        @Override
        public float height(Vec3 pos, float height){
            if(!valid(pos, height)) return height;
            if(pos.dst(this.pos) < radius) return offset + height * (set ? 0f : 1f);
            return height;
        }
    }

    public static class NoiseHeight extends HeightPassage{
        public Vec3 offset = new Vec3();
        public int seed;
        public double octaves = 1;
        public double persistence = 1.0;
        public double scale = 1.0;
        public float magnitude = 2;
        public float heightOffset = 0;

        @Override
        public float height(Vec3 pos, float height){
            return Simplex.noise3d(seed, octaves, persistence, scale, pos.x + offset.x, pos.y + offset.y, pos.z + offset.z) * magnitude + heightOffset + height;
        }
    }

    public static class ClampHeight extends HeightPassage{
        public float min, max;

        public ClampHeight(float min, float max){
            this.min = min;
            this.max = max;
        }

        @Override
        public float height(Vec3 pos, float height){
            return Mathf.clamp(height, min, max);
        }
    }

    public static class DotHeight extends HeightPassage{
        public Vec3 dir = new Vec3();
        public float min = -1f;
        public float max = 1f;
        public boolean map = true;
        public Interp interp = Interp.linear;
        public float magnitude = 1;

        @Override
        public float height(Vec3 pos, float height){
            if(!valid(pos, height)) return height;
            float dot = dir.nor().dot(pos);
            dot = Mathf.map(dot, map ? min : -1f, map ? max : 1f, 0f, 1f);
            return interp.apply(dot) * magnitude + height;
        }

        @Override
        public boolean valid(Vec3 pos, float height){
            float dot = dir.nor().dot(pos);
            return dot >= min && dot <= max;
        }
    }

    public static class MultiHeight extends HeightPassage{
        public Seq<HeightPassage> heights;
        public MixType mixType;
        public Operation operation;

        public MultiHeight(Seq<HeightPassage> heights, MixType mixType, Operation operation){
            this.heights = heights;
            this.mixType = mixType;
            this.operation = operation;
        }

        @Override
        public float height(Vec3 pos, float height){
            if(!valid(pos, height)) return height;
            switch(operation){
                case add -> {
                    return height + rawHeight(pos, height);
                }
                case set -> {
                    return rawHeight(pos, height);
                }
                case carve -> {
                    return height - rawHeight(pos, height);
                }
            }
            return height;
        }

        float rawHeight(Vec3 pos, float base){
            switch(mixType){
                case max -> {
                    return heights.select(pass -> pass.valid(pos, base)).max(pass -> pass.height(pos, base)).height(pos, base);
                }
                case average -> {
                    return heights.select(pass -> pass.valid(pos, base)).sumf(pass -> pass.height(pos, base)) / (float)heights.size;
                }
                case min -> {
                    return heights.select(pass -> pass.valid(pos, base)).min(pass -> pass.height(pos, base)).height(pos, base);
                }
            }
            return 0f;
        }

        @Override
        public boolean valid(Vec3 pos, float height){
            return heights.contains(pass -> pass.valid(pos, height));
        }

        public enum MixType{
            max, average, min
        }

        public enum Operation{
            add, set, carve
        }
    }
}
