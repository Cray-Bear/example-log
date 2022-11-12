
## Create a topic
docker exec kafka \
kafka-topics --bootstrap-server kafka:9092 \
             --create \
             --topic log

## Write messages to the topic
docker exec --interactive --tty kafka \
kafka-console-producer --bootstrap-server kafka:9092 \
                       --topic log


## Read messages from the topic
docker exec --interactive --tty kafka \
kafka-console-consumer --bootstrap-server kafka:9092 \
                       --topic log \
                       --from-beginning