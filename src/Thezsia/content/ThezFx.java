package Thezsia.content;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.Time;
import mindustry.Vars;
import mindustry.entities.Effect;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.ParticleEffect;
import mindustry.graphics.*;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.randLenVectors;
import static mindustry.Vars.tilesize;

public class ThezFx{
    public static final Effect
    launchCore = new Effect(50, e -> {
        color(Pal.engine);

        e.scaled(25f, f -> {
            stroke(f.fout() * 2f);
            Lines.circle(e.x, e.y, 4f + f.finpow() * 30f);
        });

        stroke(e.fout() * 2f);

        randLenVectors(e.id, 24, e.finpow() * 50f, (x, y) -> {
            float ang = Mathf.angle(x, y);
            lineAngle(e.x + x, e.y + y, ang, e.fout() * 4 + 1f);
        });
    }),
    craterSmoke = new MultiEffect(
            new ParticleEffect(){{
                particles = 4;
                lifetime = 150;
                length = 12f * tilesize;
                cone = 15f; baseRotation = 30f;
                sizeFrom = 0f; sizeTo = 7f; sizeInterp = Interp.pow3Out;
                colorFrom = Color.valueOf("52392f90"); colorTo = Color.valueOf("2e282210");
                interp = Interp.pow3Out;
            }},
            new ParticleEffect(){{
                startDelay = 16;
                particles = 4;
                lifetime = 180;
                length = 13f * tilesize;
                cone = 15f; baseRotation = 30f;
                sizeFrom = 0f; sizeTo = 9f; sizeInterp = Interp.pow3Out;
                colorFrom = Color.valueOf("52392f90"); colorTo = Color.valueOf("2e282210");
                interp = Interp.pow3Out;
            }},
            new ParticleEffect(){{
                startDelay = 26;
                particles = 3;
                lifetime = 210;
                length = 19f * tilesize;
                cone = 15f; baseRotation = 30f;
                sizeFrom = 0f; sizeTo = 13f; sizeInterp = Interp.pow3Out;
                colorFrom = Color.valueOf("52392f90"); colorTo = Color.valueOf("2e282210");
                interp = Interp.pow3Out;
            }}
    );
};