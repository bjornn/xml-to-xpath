# org.becube.xml-to-xpath

This is a simple command line utility that takes an xml file as input and returns a list of XPath expressions corresponding to every element and attribute present in that file.

## Installation
This project is automated with Leiningen which can be installed from
http://leiningen.org/

Project standalone jars are listed under the target/uberjar directory. If
you want to use them without installing a Clojure infrastructure grab a standalone version.

## Usage

    $ java -jar org.becube.xml-to-xpath-1.1-standalone.jar <filename>.xml

If you omit the filename you will get a helpful usage message. If you provide
a bad filename or if the file does not contain valid xml you will probably receive
a stack trace.

## Options

There are no options yet. The utility aims to do only one thing.

## Examples

...

### Bugs

...

## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
