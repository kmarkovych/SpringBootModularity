/**
 * Created by Kmarkovych on 13-Jul-16.
 */
const orderUrl = "/order";

//Fill cart on load
const fillCart = new function () {
    $.post(orderUrl, null, function (data) {
        $("#orderedAmount").text(data.items.length)
    });
}


$(document).ready(function () {
    fillCart();
});
