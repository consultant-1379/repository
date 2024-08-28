#!/bin/sh
if [ -f "/eniq/sw/conf/strong_passphrase" ]; then
                                if [ -s "/eniq/sw/conf/strong_passphrase" ]; then
                                        pass_phrase=`cat /eniq/sw/conf/strong_passphrase`
                                else
                echo "Passphrase file is empty.Hence aborting."
                exit 1
                        fi
                else
                echo "Passphrase file does not exist.Hence aborting"
                exit 1
                fi
if [ "$1" == '-e' ]; then
echo $2 | openssl enc -aes-256-ctr -md sha512 -salt -a -pass pass:${pass_phrase} > /eniq/home/dcuser/dcuser_encrypt.txt
cat /eniq/home/dcuser/dcuser_encrypt.txt
elif [ "$1" == '-d' ]; then
echo $2 | openssl enc -aes-256-ctr -md sha512 -a -d -salt -pass pass:${pass_phrase}
fi
