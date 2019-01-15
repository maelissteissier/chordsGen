#! /bin/sh
mkdir savedGeneratedChords
java -cp target/ChordProgressionGenerator-1.0-SNAPSHOT.jar:lib/jsyn-20171016.jar ChordGen "$@"
