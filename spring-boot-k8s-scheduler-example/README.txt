steps to execute this project:

1> create a mvn build
 mvn clean install

2> create a docker image
 docker build -t k8s-job-example .

3> check the container image
 docker images

4> create a reporting job in kubernetes cluster
 kubectl apply -f k8s-config.yaml

5> check the created job
 kubectl get jobs

5> watch cmd to execute cron job
    kubectl get jobs --watch
