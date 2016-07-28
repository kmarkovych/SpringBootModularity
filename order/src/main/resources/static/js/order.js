/**
 * order's logic
 * */
$(document).ready(function () {
    $.post(orderUrl, null, function (data) {
        const total = data.total;

        var sorted = data.items.slice();
        sorted.sort(function (a, b) {
            return a.id - b.id;
        });

        var basketItems = [];
        for (var i = 0, len = sorted.length; i < len; i++) {
            var item = sorted[i];
            var basketItem;
            if (basketItems.length == 0) {
                basketItem = [item.id, item.description, 1];
                basketItems.push(basketItem);
            } else {
                basketItem = basketItems.pop();
                if (basketItem[0] == item.id) {
                    basketItem[2] += 1;
                    basketItems.push(basketItem);
                } else {
                    basketItems.push(basketItem);
                    basketItems.push([item.id, item.description, 1]);
                }
            }
        }
        var orderContainer = $("#templatemo_content_left");
        if (total > 0) {
            var table = "<table style='color: black; border: 1px solid black;'><tr><th>ID</th><th>Name</th><th>Amount</th></tr>";
            for (var i = 0, len = basketItems.length; i < len; i++) {
                var item = basketItems[i];
                console.log(item);
                table += "<tr><td>" + item[0] + "</td><td>" + item[1] + "</td><td>" + item[2] + "</td></tr>";
            }
            table +=  "</table>";
            orderContainer.append(table);
            orderContainer.append("<div style='color: black;'><span style='margin-right: 10px;'>Total:</span><span>" + total + "</span></div>");
        } else {
            orderContainer.append("<div style='color: black;'><a href='/'>Order something please</a></div>");
        }
    });

});
