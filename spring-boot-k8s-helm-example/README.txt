Required:-

1> Docker Desktop-
    There you need to enable kubernetes.

2> Home brew -
    To install helm client and tree by below cmd -
    brew install helm
    brew install tree


steps to execute this project:

1> create a mvn build
 mvn clean install

2> create a docker image
 docker build -t spring-app:5.0 .

3> check the container image
 docker images

4> create a helm chart
 helm create spring-app-chart

5> check the created chart
 tree spring-app-chart

6> update the values.yaml file in spring-app-chart with the created docker image name
 image:
   repository: spring-app
   pullPolicy: IfNotPresent
   tag: "5.0"
 service:
   type: NodePort
   port: 8080

7> install the helm chart in kubernetes cluster
    helm install myapp-chart spring-app-chart

8> check the created all
 kubectl get all

9> check the created pods of the pod
 kubectl get pods

9> check the logs of the pod
    kubectl logs <pod-name>

10> access the application
 kubectl get svc myapp-chart-spring-app-chart

NAME                           TYPE       CLUSTER-IP     EXTERNAL-IP   PORT(S)          AGE
myapp-chart-spring-app-chart   NodePort   10.51.81.91   <none>        8080:30483/TCP   4m48s


11> access the application in browser
    http://localhost:<NodePort>
    http://localhost:30483

Refer the attached screenshot in resource directory for more clarity.
