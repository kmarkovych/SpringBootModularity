/**
 * Created by Kmarkovych on 13-Jul-16.
 */
const servicesUrl = "/services";
const orderUrl = "/order";
const addItemUrl = orderUrl + "/additem";
const itemListUrl = "/item";


//Fill cart on load
const fillCart = function () {
    $.post(orderUrl, null, function (data) {
        const total = data.total;
        if(total > 0) {
            $("#orderedAmount").text(total)
        }

        data.items.sort();

    });
}



var fillMenu = function () {
    var menuContainer = $("#templatemo_menu");
    $.post(servicesUrl, null, function(data){
        var ul = document.createElement("ul");
        $.each(data, function(i, item){
            var li = document.createElement("li");
            var a = document.createElement("a");
            a.href = item.url;
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
