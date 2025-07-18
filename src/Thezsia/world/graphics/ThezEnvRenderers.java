package Thezsia.world.graphics;

import Thezsia.world.meta.ThezEnv;
import arc.*;
import arc.graphics.*;
import arc.graphics.Texture.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.graphics.Layer;
import mindustry.graphics.Shaders;
import mindustry.type.*;

import static mindustry.Vars.*;

public class ThezEnvRenderers{

    public static void init(){

        Color waterColor = Color.valueOf("363159"); //First ver — 353982. Second ver — 30626e. Third ver — 363159.
        Color darknessColor = Color.valueOf("28252b"); //First ver — 2e2d40.
        Rand rand = new Rand();

        Core.assets.load("sprites/rays.png", Texture.class).loaded = t -> {
            t.setFilter(TextureFilter.linear);
        };

        Color particleWaterColor = Color.valueOf("c48d94"); //a7c1fa
        float windSpeed = 0.07f, windAngle = 45f;
        float darkWindSpeed = 0.56f, darkWindAngle = 170;
        float windx = Mathf.cosDeg(windAngle) * windSpeed, windy = Mathf.sinDeg(windAngle) * windSpeed;

        renderer.addEnvRenderer(ThezEnv.underwaterWarm, () -> {
            Draw.draw(Layer.light + 1, () -> {
                Draw.color(waterColor, 0.3f);
                Fill.rect(Core.camera.position.x, Core.camera.position.y, Core.camera.width, Core.camera.height);
                Draw.reset();

                Blending.additive.apply();
                Draw.blit(Shaders.caustics);
                Blending.normal.apply();
            });

            Draw.z(Layer.light + 2);

            int rays = 50;
            float timeScale = 2000f;
            rand.setSeed(0);

            Draw.blend(Blending.additive);

            float t = Time.time / timeScale;
            Texture tex = Core.assets.get("sprites/rays.png", Texture.class);

            for(int i = 0; i < rays; i++){
                float offset = rand.random(0f, 1f);
                float time = t + offset;

                int pos = (int)time;
                float life = time % 1f;
                float opacity = rand.random(0.2f, 0.7f) * Mathf.slope(life) * 0.7f;
                float x = (rand.random(0f, world.unitWidth()) + (pos % 100)*753) % world.unitWidth();
                float y = (rand.random(0f, world.unitHeight()) + (pos % 120)*453) % world.unitHeight();
                float rot = rand.range(7f);
                float sizeScale = 1f + rand.range(0.3f);

                float topDst = (Core.camera.position.y + Core.camera.height/2f) - (y + tex.height/2f + tex.height*1.9f*sizeScale/2f);
                float invDst = topDst/1000f;
                opacity = Math.min(opacity, -invDst);

                if(opacity > 0.01){
                    Draw.alpha(opacity);
                    Draw.rect(Draw.wrap(tex), x, y + tex.height/2f, tex.width*2*sizeScale, tex.height*2*sizeScale, rot);
                    Draw.color();
                }
            }

            /* Suspended particles */
            Draw.draw(Layer.weather, () -> {
                Weather.drawParticles(
                    Core.atlas.find("particle"), particleWaterColor,
                    0.6f, 6f, //minmax size
                    10000f, 1.2f, 1f, //density
                    windx, windy, //wind vectors
                    0.1f, 0.7f, //minmax alpha
                    45f, 90f, //sinscl
                    1f, 8f, //sinmag
                    false
                );
            });

            Draw.blend();
        });

        renderer.addEnvRenderer(ThezEnv.darkness, () -> {
            Draw.draw(Layer.light + 1, () -> {
                Draw.color(darknessColor, 0.32f);
                Fill.rect(Core.camera.position.x, Core.camera.position.y, Core.camera.width, Core.camera.height);
                Draw.reset();

                Blending.additive.apply();
                //Draw.blit(Shaders.caustics);
                Blending.normal.apply();
            });

            Draw.z(Layer.light + 2);

            int darkRays = 50;
            float timeScale = 3600f; // 2000
            rand.setSeed(0);

            Draw.blend(Blending.additive);

            float t = Time.time / timeScale;
            Texture tex = Core.assets.get("sprites/rays.png", Texture.class);

            for(int i = 0; i < darkRays; i++){
                float offset = rand.random(0f, 1f);
                float time = t + offset;

                int pos = (int)time;
                float life = time % 1f;
                float opacity = rand.random(0.3f, 0.6f) * Mathf.slope(life) * 0.8f;
                float x = (rand.random(0f, world.unitWidth()) + (pos % 100)*753) % world.unitWidth();
                float y = (rand.random(0f, world.unitHeight()) + (pos % 120)*453) % world.unitHeight();
                float rot = rand.range(6f);
                float sizeScale = 1f + rand.range(0.4f);

                float topDst = (Core.camera.position.y + Core.camera.height/2f) - (y + tex.height/2f + tex.height*1.9f*sizeScale/2f);
                float invDst = topDst/1000f;
                opacity = Math.min(opacity, -invDst);

                if(opacity > 0.015f){
                    Draw.alpha(opacity);
                    Draw.rect(Draw.wrap(tex), x, y + tex.height/2f, tex.width*2*sizeScale, tex.height*2*sizeScale, rot);
                    Draw.color();
                }
            }

            /* Suspended particles */
            /*Draw.draw(Layer.weather, () -> {
                Weather.drawParticles(
                        Core.atlas.find("particle"), particleColor,
                        0.6f, 6f, //minmax size
                        10000f, 1.2f, 1f, //density
                        windx, windy, //wind vectors
                        0.1f, 0.7f, //minmax alpha
                        45f, 90f, //sinscl
                        1f, 8f, //sinmag
                        false
                );
            });*/

            Draw.blend();
        });

        /*Core.assets.load("sprites/distortAlpha.png", Texture.class);

        renderer.addEnvRenderer(Env.scorching, () -> {
            Texture tex = Core.assets.get("sprites/distortAlpha.png", Texture.class);
            if(tex.getMagFilter() != TextureFilter.linear){
                tex.setFilter(TextureFilter.linear);
                tex.setWrap(TextureWrap.repeat);
            }

            //TODO layer looks better? should not be conditional
            Draw.z(state.rules.fog ? Layer.fogOfWar + 1 : Layer.weather - 1);
            Weather.drawNoiseLayers(tex, Color.scarlet, 1000f, 0.24f, 0.4f, 1f, 1f, 0f, 4, -1.3f, 0.7f, 0.8f, 0.9f);
            Draw.reset();
        });*/
    }

}
