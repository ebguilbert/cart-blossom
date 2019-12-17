# Blossom cart module for Magnolia CMS

Provides a blossom component which will handle shopping items in a session shopping cart.

This component can be used in any page and communicate with any other component through the pecid parameter.

## Usage

Latest version has been adapted to be used with basic template of MTK, its automatically added to the footer area.

To use the cart in any other page, you need to add the component to an area:

```
areas:
  footer:
    availableComponents:
      cart:
        id: cart-blossom:components/cart
```

In order to easily test the cart. An stantard (non-blossom) component has been added:

```
areas:
  main:
    availableComponents:
      cartItem:
        id: cart-blossom:components/item
```

## Magnolia 6

Version for Magnolia 6 is currently testing phase.

## Contributors

Edwin Guilbert, http://www.edwinology.com

Magnolia, https://magnolia-cms.com

