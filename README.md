# Chord progression generator
This program generates a **random musical chord progression** that makes sense in **tonal music**. After playing the generated progression, the chords will be written in a text file in the `savedGeneratedChords` directory.

## Prerequisites

- JDK 1.8+
- Maven

## Installation

```sh
$ git clone https://github.com/maelissteissier/chordsGen
$ cd chordsGen
$ mvn package
$ ./chordsGen.sh "G#" minor 6 2 both
```

**Arguments references**
```sh
$ ./chordsGen.sh [KEY] [SCALETYPE] [NUMBER OF CHORDS] [STARTING DEGREE] [PLAY SOUND]
```

|               |                       |
|:-------------------|:------------------------------------ |  
|KEY                 | C, C#, Eb ...                        |  
|SCALETYPE           | major or minor                       |
|NUMBER OF CHORDS    | number of chords you want to generate|  
|STARTING DEGREE     | from 1 to 7                          |  
|PLAY SOUND          | arpeggios, chords, both, silent      |  
|                    |                                      | 

 
## License

> This project is licensed under the Apache License - see the [LICENSE](./LICENSE) file for detailss

## Acknowledgments

> This program uses [JSyn](https://github.com/philburk/jsyn) under the Apache license.
