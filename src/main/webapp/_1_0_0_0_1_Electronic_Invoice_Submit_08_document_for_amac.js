$(".readOnly").prop("readonly", true);
function amac_calculation() {

    var minimumLimit = $("#minimumLimit").val();
    if (minimumLimit < 0) {
        minimumLimit = 0;
        $("#minimumLimit").val(minimumLimit);
    }

    var calcUnit = $("#calcUnit").val();
    var priceBeforeCalcUnit = $("#priceBeforeCalcUnit").val();

    if (calcUnit === "") {
        calcUnit = 1;
        $("#calcUnit").val(calcUnit);
    }

    if (+calcUnit === 0 && calcUnit !== "") {
        Warning("لا يمكن ان تكون وحدة الحساب صفرا ");
        calcUnit = 1;
        $("#calcUnit").val(calcUnit);
    } else {
        calcUnit = parseFloat(calcUnit).toFixed(5);
        priceBeforeCalcUnit = parseFloat(priceBeforeCalcUnit).toFixed(5)

        var price = priceBeforeCalcUnit / calcUnit;

        price = price.toFixed(5);
        $("#price").val(price);
    }

    changeDiscountAmount();
}