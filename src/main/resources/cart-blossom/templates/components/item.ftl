
 
 <div>
 	<form action="">
 		<input type="hidden" name="action" value="add">
		<input type="hidden" name="product" value="${content.cartItem!"Item"}">
		<input type="hidden" name="url" value="${cmsfn.contentById(content.targetPage).@path}">
		<input type="hidden" name="_pecid" value="${content.cartId!}">
		${content.cartItem!"Item"} - <input class="" type="submit" value="Add to cart">
	</form>
 </div>