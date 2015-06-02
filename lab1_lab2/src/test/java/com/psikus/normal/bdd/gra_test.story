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
Then cyfrokrad with 2 possibilities returns either 1 or 0

When set number to 100
Then cyfrokrad with 2 possibilities returns either 10 or 0

When set number to -10
Then cyfrokrad with 2 possibilities returns either -1 or 0

When set number to -100
Then cyfrokrad with 2 possibilities returns either -10 or 0

When set number to 12
Then cyfrokrad with 2 possibilities returns either 1 or 2

When set number to 54
Then cyfrokrad with 2 possibilities returns either 5 or 4

When set number to -76
Then cyfrokrad with 2 possibilities returns either -7 or -6

When set number to 123
Then cyfrokrad with 3 possibilities returns either 12 or 13 or 23

When set number to -123
Then cyfrokrad with 3 possibilities returns either -12 or -13 or -23

When set number to 789
Then cyfrokrad with 3 possibilities returns either 78 or 79 or 89

When set number to 1
Then nieksztaltek returns 1

When set number to 2
Then nieksztaltek returns 2

When set number to 4
Then nieksztaltek returns 4

When set number to 8
Then nieksztaltek returns 8

When set number to 9
Then nieksztaltek returns 9

When set number to 7
Then nieksztaltek returns 1

When set number to 3
Then nieksztaltek returns 8

When set number to 6
Then nieksztaltek returns 9

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
