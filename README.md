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

Blossom 3.3+ is compatible with Magnolia 6.

The module is fully compatible with Magnolia 6 and can be used as a base for your own blossom modules on latest versions of Magnolia.

**As an important note:**

In order to use blossom with DX Core a personalization compatibility module has to be added:
```
  	<dependency>
  		<groupId>info.magnolia.personalization</groupId>
  		<artifactId>magnolia-personalization-blossom-compatibility</artifactId>
  		<version>latest_version</version>
	</dependency> 
```
For the community edition this is not required.

## Contributors

Edwin Guilbert, http://www.edwinology.com

Magnolia, https://magnolia-cms.com

