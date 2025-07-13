package Thezsia.world.meta;

import arc.graphics.Color;
import mindustry.game.Team;

public class ThezTeams {
    public static Team precursors, vanitser, pebbles;

    public static void load() {
        precursors = newTeam(80, "precursors", Color.valueOf("6bebcd"));
        vanitser = newTeam(81, "vanitser", Color.valueOf("524b7e"));
        pebbles = newTeam(82, "pebbles", Color.valueOf("473639"));
    }

    //modify any of 256 teams' properties
    private static Team newTeam(int id, String name, Color color) {
        Team team = Team.get(id);
        team.name = name;
        team.color.set(color);

        team.palette[0] = color;
        team.palette[1] = color.cpy().mul(0.75f);
        team.palette[2] = color.cpy().mul(0.5f);

        for(int i = 0; i < 3; i++){
            team.palettei[i] = team.palette[i].rgba();
        }

        return team;
    }
}
