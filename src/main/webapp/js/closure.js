function getBmiCalculator(height, weight) {
    // These are private vars
    var height = height;
    var weight = weight;

    function calculateBmi(){
        return weight / (height * height);
    }
    return calculateBmi;
}

var calc = getBmiCalculator(1.85, 90);

// calc still has access to the scope where height and weight live.
var bmi = calc();
console.log(bmi);