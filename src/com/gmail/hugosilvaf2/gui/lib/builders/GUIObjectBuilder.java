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
package com.gmail.hugosilvaf2.gui.lib.builders;

import com.gmail.hugosilvaf2.gui.lib.GUI;
import com.gmail.hugosilvaf2.gui.lib.GUIObject;
import com.gmail.hugosilvaf2.gui.lib.Result;
import com.gmail.hugosilvaf2.gui.lib.Source;
import org.bukkit.inventory.ItemStack;

public class GUIObjectBuilder {

    private String name;
    private ItemStack icon;
    private Result result;
    private GUI openNewGUI;
    private int location;
    private boolean cancelClick;

    public GUIObjectBuilder() {
        result = Result.NOTHING;
    }

    /**
     * Obtém o ícone
     *
     * @return
     */
    public ItemStack getIcon() {
        return icon;
    }

    /**
     * Obtém o nome do GUIObject
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Obtém o resultado do GUIObject, se ele irá para próxima página etc..
     *
     * @return
     */
    public Result getResult() {
        return result;
    }

    /**
     * Pega o novo GUI que será aberto ao clicar neste GUIObject
     *
     * @return
     */
    public GUI getOpenNewGUI() {
        return openNewGUI;
    }

    /**
     * Pega a localização deste GUIObject
     *
     * @return
     */
    public int getLocation() {
        return location;
    }

    /**
     * Checa se o click será cancelado ao clicar no GUIObject
     *
     * @return
     */
    public boolean isCancelClick() {
        return cancelClick;
    }

    /**
     * Seta a localização do GUIObject
     *
     * @param location
     */
    public void setLocation(int location) {
        this.location = location;
    }

    /**
     * Seta se o click será cancelado ao clicar no GUIObject
     *
     * @param cancelClick
     * @return
     */
    public GUIObjectBuilder setCancelClick(boolean cancelClick) {
        this.cancelClick = cancelClick;
        return this;
    }

    /**
     * Seta o novo GUI que será aberto ao clicar no objeto, e se o restulado
     * retornar OPEN_NEW
     *
     * @param openNewGUI
     * @return
     */
    public GUIObjectBuilder setOpenNewGUI(GUI openNewGUI) {
        this.openNewGUI = openNewGUI;
        return this;
    }

    /**
     * Seta o ícone do GUIObject
     *
     * @param icon
     * @return
     */
    public GUIObjectBuilder setIcon(ItemStack icon) {
        this.icon = icon;
        return this;
    }

    /**
     * Seta o nome do GUIObject
     *
     * @param name
     * @return
     */
    public GUIObjectBuilder setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Seta o resultado do GUIObject
     *
     * @param result
     * @return
     */
    public GUIObjectBuilder setResult(Result result) {
        this.result = result;
        return this;
    }

    /**
     * Obtém a instancia desta classe
     *
     * @return
     */
    public static GUIObjectBuilder instance() {
        return new GUIObjectBuilder();
    }

    /**
     * Constroi o GUIObject
     *
     * @return
     */
    public GUIObject build() {
        return new GUIObject(name, icon, openNewGUI, cancelClick) {
            public Result onClick(Source source) {
                return result;
            }
        };
    }
}
