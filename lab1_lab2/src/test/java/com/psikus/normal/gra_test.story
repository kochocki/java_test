Given Game

When set number to 1
Then cyfrokrad returns null

When set number to 0
Then cyfrokrad returns null

When set number to -1
Then cyfrokrad returns null

When set number to 9
Then cyfrokrad returns null

When set number to -9
Then cyfrokrad returns null

When set number to 10
Then cyfrokrad returns either 1 or 0

When set number to -10
Then cyfrokrad returns either -1 or 0

When set number to 12
Then cyfrokrad returns either 1 or 2

When set number to 54
Then cyfrokrad returns either 5 or 4

When set number to -76
Then cyfrokrad returns either -7 or -6

When set number to -137
Then nieksztaltek returns either -187 or -131

When set number to 33
Then nieksztaltek returns either 38 or 83

When set number to -33
Then nieksztaltek returns either -38 or -83

When set number to 1
Then hultajchochla throws NieduanyPsikusException

When set number to 0
Then hultajchochla throws NieduanyPsikusException

When set number to -1
Then hultajchochla throws NieduanyPsikusException

When set number to 9
Then hultajchochla throws NieduanyPsikusException

When set number to -9
Then hultajchochla throws NieduanyPsikusException

When set number to 123
Then hultajchochla returns either 132 or 213 or 321

When set number to 256
Then hultajchochla returns either 265 or 652 or 526

When set number to -123
Then hultajchochla returns either -132 or -213 or -321

When set number to -256
Then hultajchochla returns either -265 or -652 or -526
