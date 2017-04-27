package openexpo.magnolia.templates.component;

import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.ui.form.config.TabBuilder;
import info.magnolia.ui.framework.config.UiConfig;

import javax.jcr.Node;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Template(id = "cart-blossom:components/cart", title = "Blossom Cart")
@Controller
public class CartComponent {

    @RequestMapping("/cart")
    public String render(ModelMap model, HttpSession session, HttpServletRequest request, Node content) {

        ShoppingCart shoppingCart = ShoppingCart.getShoppingCart(session);

        if ("add".equals(request.getParameter("action"))) {

            String product = request.getParameter("product");

            shoppingCart = ShoppingCart.getShoppingCart(session);

            String quantity = "1";

            if (request.getParameter("quantity") != null)
                quantity = request.getParameter("quantity");

            shoppingCart.addItem(product, Integer.parseInt(quantity));

            String url = request.getParameter("url") + ".html";

            return "redirect:" + ((url != null) ? url : request.getRequestURL());
        }

        model.put("shoppingCart", shoppingCart);

        return "components/cart.ftl";
    }

    @TabFactory("Content")
    public void contentTab(UiConfig cfg, TabBuilder tab) {
        tab.fields(
                cfg.fields.text("title").label("Title").description("Enter here the cart title"),
                cfg.fields.checkbox("size").label("Size").description("Check this box to have the size shown").buttonLabel("")
                );
    }
}
