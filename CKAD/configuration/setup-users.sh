#!/usr/bin/env bash
sudo useradd -u 2000 ctr-user-0
sudo groupadd -g 3000 ctr-grp-0

sudo useradd -u 2001 ctr-user-1
sudo groupadd -g 3001 ctr-grp-1

sudo mkdir -p /etc/messages/
echo "Hello, Sai!" | sudo tee -a /etc/messages/msg.txt
sudo chown 2000:3000 /etc/messages/msg.txt
sudo chmod 640 /etc/messages/msg.txt

ls -lrt /etc/messages/msg.txt
