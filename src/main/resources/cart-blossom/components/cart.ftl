<div>
    <h3>
    ID: ${content.@id}
    </h3>
    <h4>
    ${content.title!CART}
    [#if content.size?has_content && content.size]
    : ${shoppingCart.getNumberOfItems()}
    [/#if]
    </h4>
    <p>
    <ul>
    [#list shoppingCart.items as item]
      <li>${item.quantity} x ${item.product}</li>
    [/#list]
    </ul>
    </p>
</div>