# Input-Output Tasks
by Pasut Kittiprapas

I ran the tasks on a Dell Latitude E7270 with 2.6GHz i7-6600U, and i got these results:

| Type      | Elapsed (sec.) |
| :------------| -----:|
| Read file 1-char at a time to String       | 1.018123 |
| Read file 1-char at a time to StringBuilder      |   0.006354 |
| Read file line at a time using BufferedReader  |  0.036220 |

## Explanation of Results
Stringbuilder is the fastest, BufferedReader is the second, and String is the third.