# spring-boot-kubernetes-projects

spring boot applications deployed in kubernetes cluster

common cmds used related to kubernetes deployment :-

1> create a application build

mvn clean install -Dmaven.skip.test

2> create docker image first

docker build -t spring-boot-kubernetes-example:1.0 .

3> cmd to check the images

docker images

4> Now create a deployment.yaml in the parent directory, in this case I have created k8s-deployment.yaml
now execute below cmd to create a deployment object

kubectl apply -f k8s-deployment.yaml

o/p - deployment.apps/spring-boot-kubernetes-example created

5> cmd to check deployment objects

kubectl get deployments

o/p -

NAME                             READY   UP-TO-DATE   AVAILABLE   AGE
spring-boot-kubernetes-example   3/3     3            3           40s

6> cmd to check kubernetes pods

kubectl get pods

o/p -

NAME                                              READY   STATUS    RESTARTS   AGE
spring-boot-kubernetes-example-576e63t378-6t5au   1/1     Running   0          91s
spring-boot-kubernetes-example-576e63t378-jja6a   1/1     Running   0          91s
spring-boot-kubernetes-example-576e63t378-ha6u1   1/1     Running   0          91s

7> cmd to check the application logs 

kubectl logs spring-boot-kubernetes-example-576e63t378-6t5au
kubectl logs spring-boot-kubernetes-example-576e63t378-jja6a
kubectl logs spring-boot-kubernetes-example-576e63t378-ha6u1

8> Now create a service.yaml in the parent directory, in this case I have created k8s-service.yaml
now execute below cmd to create a service object

kubectl apply -f k8s-service.yaml

o/p - service/spring-boot-kubernetes-example-service created

9> cmd to check service running

kubectl get service

or

kubectl get svc

o/p -

NAME                                     TYPE        CLUSTER-IP       EXTERNAL-IP   PORT(S)          AGE
kubernetes                               ClusterIP   10.81.0.1        <none>        443/TCP          34d
spring-boot-kubernetes-example-service   NodePort    10.171.328.191   <none>        8080:31981/TCP   56s

10> cmd to check the node details:

kubectl get nodes -o wide

11> cmd to get the particular service

kubectl get svc spring-boot-kubernetes-example-service

o/p - NAME                                     TYPE       CLUSTER-IP       EXTERNAL-IP   PORT(S)          AGE
spring-boot-kubernetes-example-service   NodePort   10.171.328.191   <none>        8080:31981/TCP   30m


12> cmd to get the endpoints of the serices running

kubectl get endpoints spring-boot-kubernetes-example-service

13> port forwarding kubectl cmd to access the api to particular port for temporary purpose

kubectl port-forward svc/spring-boot-kubernetes-example-service 8080:8080

14> configure agrocd(Argo CD is a declarative, GitOps continuous delivery (CD) tool specifically built for Kubernetes. At its core, it acts as a Kubernetes controller that continuously monitors your Git repositories for any changes to your application manifests (YAML, Helm charts, or Kustomize files)) app in kubernetes

cmd to create agrocd namespace

kubectl create namespace argocd

o/p - namespace/argocd created

15> Install Argo CD components and CRDs(Custom Resource Definitions)

kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml

16> Verify the CRDs are Installed

kubectl get crds | grep argoproj.io

we should see applications.argoproj.io in the list.

17> apply your app.yaml file

kubectl apply -f k8s-app.yaml

18> Access the Argo CD UI

Since you are on Docker Desktop, you can access the dashboard to see your application status:

cmd for Port Forward:

kubectl port-forward svc/argocd-server -n argocd 8080:443

cmd for Get Password:

kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath="{.data.password}" | base64 -d; echo

Login: Open https://localhost:8080 with username admin and generated pwds

