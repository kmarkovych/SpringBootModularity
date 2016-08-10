/**
 * Created by Kmarkovych on 13-Jul-16.
 */
const servicesUrl = "./services";
const orderUrl = "./order";
const addItemUrl = orderUrl + "/additem";
const itemListUrl = "./item";


//Fill cart on load
const fillCart = function () {
    $.post(orderUrl, null, function (data) {
        const total = data.total;
        if (total > 0) {
            $("#orderedAmount").text(total)
        }
        var sorted = data.items.slice();
        sorted.sort(function (a, b) {
            return a.id - b.id;
        });

        var basketItems = [];
        for (var i = 0, len = sorted.length; i < len; i++) {
            var item = sorted[i];
            var basketItem;
            if (basketItems.length == 0){
                basketItem = [item.id, item.description, 1];
                basketItems.push(basketItem);
            }else{
                basketItem = basketItems.pop();
                if(basketItem[0] == item.id){
                    basketItem[2] += 1;
                    basketItems.push(basketItem);
                }else{
                    basketItems.push(basketItem);
                    basketItems.push([item.id, item.description, 1]);
                }
            }
        }

    }).fail(function(){
        var orderedAmount = $("#orderedAmount");
        orderedAmount.text("Order processing is unavailable!");
        orderedAmount.css("font-weight", "bold");
        setTimeout(function(){
            orderedAmount.css("font-weight", "normal");
        }, 1000);

    });
}


var fillMenu = function () {
    var menuContainer = $("#templatemo_menu");
    $.post(servicesUrl, null, function (data) {
        var ul = document.createElement("ul");
        $.each(data, function (i, item) {
            var li = document.createElement("li");
            var a = document.createElement("a");
            a.href = "./" + item.url;
            a.innerHTML = item.name;
            li.appendChild(a);
            ul.appendChild(li);
        })
        menuContainer.empty().append(ul);
    })
};
$(document).ready(function () {
    fillMenu();
    fillCart();
});
