
//Fill items
const fillItemListDeffered = $.post(itemListUrl, null, function (data) {
    var itemsContainer = $("#templatemo_content_left");
    $.each(data, function (i, item) {
        itemsContainer.append(createItemView(item));
    })
});


//Creates teplate for each item
const createItemView = function (item) {
    var root = document.createElement("div");
    root.className = "templatemo_pizza_box";

    var img = document.createElement("img");
    img.alt = "Pizza";
    img.src = "images/templatemo_pizza.jpg";
    root.appendChild(img);

    var textBox = document.createElement("div");
    textBox.className = "textbox";

    var a = document.createElement("a");
    a.className = "order-item";
    a.href = addItemUrl;
    a.rel = item.id;
    a.shape = "rect";
    a.innerHTML = item.description;
    textBox.appendChild(a);
    root.appendChild(textBox);

    return root;
};

//Add item to order
const addItemClickHandler = function () {
    $("a.order-item").click(function (e) {
        $("#orderedAmount").text("")
        var popID = $(this).attr('rel');
        $.get(addItemUrl, {"itemid": popID}, function (data) {
            $("#orderedAmount").text(data.total)
        }).fail(function(){
            var orderedAmount = $("#orderedAmount");
            orderedAmount.text("Order processing is unavailable!");
            orderedAmount.css("font-weight", "bold");
            setTimeout(function(){
                orderedAmount.css("font-weight", "normal");
            }, 1000);

        });
        e.preventDefault();
    });
};


$(document).ready(function () {
    $.when(fillItemListDeffered).done(addItemClickHandler);
});
