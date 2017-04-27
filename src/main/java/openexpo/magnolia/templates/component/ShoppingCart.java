/**
 * This file Copyright (c) 2010-2016 Magnolia International
 * Ltd.  (http://www.magnolia-cms.com). All rights reserved.
 *
 *
 * This file is dual-licensed under both the Magnolia
 * Network Agreement and the GNU General Public License.
 * You may elect to use one or the other of these licenses.
 *
 * This file is distributed in the hope that it will be
 * useful, but AS-IS and WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE, TITLE, or NONINFRINGEMENT.
 * Redistribution, except as permitted by whichever of the GPL
 * or MNA you select, is prohibited.
 *
 * 1. For the GPL license (GPL), you can redistribute and/or
 * modify this file under the terms of the GNU General
 * Public License, Version 3, as published by the Free Software
 * Foundation.  You should have received a copy of the GNU
 * General Public License, Version 3 along with this program;
 * if not, write to the Free Software Foundation, Inc., 51
 * Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * 2. For the Magnolia Network Agreement (MNA), this file
 * and the accompanying materials are made available under the
 * terms of the MNA which accompanies this distribution, and
 * is available at http://www.magnolia-cms.com/mna.html
 *
 * Any modifications to this file must keep this entire header
 * intact.
 *
 */
package openexpo.magnolia.templates.component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * The shopping cart is held in session.
 */
@SuppressWarnings("serial")
public class ShoppingCart implements Serializable {

    private List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public void addItem(String product, int quantity) {
        ShoppingCartItem newItem = new ShoppingCartItem(product, quantity);

        boolean found = false;
        for (Iterator<ShoppingCartItem> iterator = items.iterator(); iterator.hasNext();) {
            ShoppingCartItem shoppingCartItem = (ShoppingCartItem) iterator
                    .next();
            if (newItem.equals(shoppingCartItem)) {
                shoppingCartItem.setQuantity(shoppingCartItem.getQuantity() + quantity);
                found = true;
                break;
            }

        }

        if (!found)
            items.add(newItem);
    }

    public int getNumberOfItems() {
        int totalItems = 0;
        for (ShoppingCartItem item : items) {
            totalItems += item.getQuantity();
        }
        return totalItems;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

    public static ShoppingCart getShoppingCart(HttpSession session) {
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            session.setAttribute("shoppingCart", shoppingCart);
        }
        return shoppingCart;
    }
}
