var randomScalingFactor = function() {
    return Math.round(Math.random() * 100);
};
var randomColorFactor = function() {
    return Math.round(Math.random() * 255);
};

var config = {
    type: 'doughnut',
    data: {
        datasets: [{
            data: [
                randomScalingFactor(),
                randomScalingFactor()

            ],
            backgroundColor: [
                "#F7464A",
                "#FFFFFF",
                "#FDB45C",
                "#949FB1",
                "#4D5360"
            ]
        },
            {
                data: [
                    randomScalingFactor(),
                    randomScalingFactor()
                ],
                backgroundColor: [
                    "#46BFBD",
                    "#FFFFFF"
                ],
            },
            {
                data: [
                    randomScalingFactor(),
                    randomScalingFactor()

                ],
                backgroundColor: [

                    "#FDB45C",
                    "#FFFFFF"
                ],
            },

            {
                data: [
                    randomScalingFactor(),
                    randomScalingFactor()

                ],
                backgroundColor: [
                    "#949FB1",
                    "#FFFFFF"
                ]
            }],
        labels: [
            "ERPI",
            "AQI",
            "Sound",
            "Pressure"
        ]
    },
    options: {
        responsive: true
    }
};


var ctx = document.getElementById("donutChart");
var myDoughnut = new Chart(ctx, config);
