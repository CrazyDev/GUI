/*
 * Copyright (C) 2018 Hugo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.gmail.hugosilvaf2.gui.lib.sections;

import java.util.ArrayList;
import java.util.Optional;
import org.bukkit.entity.Player;

public class Sections
        extends ArrayList<Section> {

    public Sections() {
    }

    /**
     * Obtém a seção através do jogador
     *
     * @param player
     * @return
     */
    public Section getSection(Player player) {
        return getSection(player.getName());
    }

    /**
     * Obtém a seção através do nome do jogador
     *
     * @param name
     * @return
     */
    public Section getSection(String name) {
        return getOptionalSection(name).get();
    }

    /**
     * Obtém a seção através do nome do jogador
     *
     * @param name
     * @return
     */
    public Optional<Section> getOptionalSection(String name) {
        return stream().filter(a -> a.getViewer().getName().equals(name)).findFirst();
    }

    /**
     * Obtém a boolean através do jogador, se a seção existe, true, se não false
     *
     * @param name
     * @return
     */
    public boolean hasSection(Player player) {
        return hasSection(player.getName());
    }

    /**
     * Obtém a boolean através do nome, se a seção existe, true, se não false
     *
     * @param name
     * @return
     */
    public boolean hasSection(String name) {
        return getOptionalSection(name).isPresent();
    }
}
