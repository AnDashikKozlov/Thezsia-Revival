package Thezsia.world.graphics;

import arc.Core;
import arc.graphics.g2d.*;
import arc.math.*;
import mindustry.*;

import static arc.Core.*;
import static arc.math.Mathf.*;

// Thanks MEEPofFaith for this code
// https://github.com/MEEPofFaith/tantros-but-java/blob/master/src/poly/tantros/graphics/DrawPseudo3D.java
public class Pseudo3D {
    public static float xHeight(float x, float height){
        if(height <= 0) return x;
        return x + xOffset(x, height);
    }

    public static float yHeight(float y, float height){
        if(height <= 0) return y;
        return y + yOffset(y, height);
    }

    public static float xOffset(float x, float height){
        return (x - camera.position.x) * hMul(height);
    }

    public static float yOffset(float y, float height){
        return (y - camera.position.y) * hMul(height);
    }

    public static float hScale(float height){
        return 1f + hMul(height);
    }

    public static float hMul(float height){
        return height * Vars.renderer.getDisplayScale();
    }

    public static float layerOffset(float x, float y, float height){
        float max = Math.max(camera.width, camera.height);
        return -dst(x, y, camera.position.x, camera.position.y) / max / 1000f + height / 10000f;
    }

    public static float heightFade(float height){
        float scl = hScale(height);
        return 1f - Mathf.curve(scl, 1.5f, 7f);
    }


    public static void rect(TextureRegion region, float x, float y, float height){
        rect(region, x, y, height, 0);
    }

    public static void rect(TextureRegion region, float x, float y, float height, float rotation){
        float z = Draw.z();
        float xscl = Draw.xscl;
        float yscl = Draw.yscl;
        float alpha = Draw.getColorAlpha();

        Draw.z(z + Pseudo3D.layerOffset(x, y, height));
        Draw.scl(Pseudo3D.hScale(height));
        Draw.alpha(alpha * Pseudo3D.heightFade(height));

        Draw.rect(region, Pseudo3D.xHeight(x, height), Pseudo3D.yHeight(y, height), rotation);

        Draw.z(z);
        Draw.scl(xscl, yscl);
        Draw.alpha(alpha);
    }

    public static void line(float x, float y, float h, float x2, float y2, float h2){
        line(x, y, h, x2, y2, h2, true);
    }

    public static void line(float x, float y, float h, float x2, float y2, float h2, boolean cap){
        line(Core.atlas.white(), x, y, h, x2, y2, h2, cap);
    }

    public static void line(TextureRegion region, float x, float y, float h, float x2, float y2, float h2, boolean cap){
        float z = Draw.z();
        float alpha = Draw.getColorAlpha();

        Draw.z(z + Pseudo3D.layerOffset(x, y, h2));
        Draw.alpha(alpha * Pseudo3D.heightFade(h2));

        Lines.line(region, Pseudo3D.xHeight(x, h), Pseudo3D.yHeight(y, h), Pseudo3D.xHeight(x2, h2), Pseudo3D.yHeight(y2, h2), cap);

        Draw.z(z);
        Draw.alpha(alpha);
    }
}