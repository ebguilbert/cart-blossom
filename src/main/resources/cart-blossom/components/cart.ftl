<div>
[#if cmsfn.editMode]
    <h3>
    CART ID for requests: ${content.@id}
    </h3>
[/#if]    
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