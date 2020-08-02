#!/bin/bash

##java --module-path out --module packt.addressbook/packt.addressbook.Main
java --module-path out:libs:/usr/share/openjfx/lib \
    --add-modules=javafx.base,javafx.controls,javafx.graphics \
    -m ejemplo/ejemplo1.Main