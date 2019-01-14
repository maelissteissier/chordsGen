# Chord progression generator

This program generates a random musical chord progression that makes sense in tonal music. You have to chose the key, the starting degree, the number of chords you wants and if you want the program to play the chords for you. In any case, a text file will be saved on your computer in case you like the progression and you want to re-use it. For now you wont be able to hear it again so you are free to play it by yourself on a piano with the text file datas (the degrees progression, the names of the chords and the inversions for each chord).

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites


```
Give examples
```

### Installing

- You have to download the whole project.
- Then you can try the program by launching the script in the root file called chordGen.sh
- finally you will need to enter 5 arguments :

KEY,                   C, C# ...
SCALETYPE,             major or minor
NUMBER OF CHORDS,      number of chords you want to generate
STARTING DEGREE,       from 1 to 7
PLAY SOUND,            arpeggios, chords, both, silent


For example, in a terminal, first ``cd`` to the project and type

```
./chordGen.sh G# minor 6 2 both
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
