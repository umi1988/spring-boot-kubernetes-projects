
steps to execute this project(using docker desktop kubernetes):-

1> course-service

create a spring boot course service projects

cmd used :-

mvn clean install (build jar file based on pom.xml file)

docker build -t learn1988/course-service:2.0 . (build a docker image based on docker file config)

docker images (show images)

docker push learn1988/course-service:2.0 (push the docker image to docker hub)

kubectl apply -f k8s-course-config.yaml (tell k8s to synchronize the current state of your cluster with the "desired state" defined in that specific YAML file)

kubectl delete deployment course-service-deployment (delete the not required deployment)

kubectl get all (kubectl get all retrieves a summary of the most common resources in your current namespace)

kubectl delete service spring-boot-k8s-course-service-example (delete the not required services)


2> blog-service

create a spring boot blog service projects

cmd used :-

mvn clean install (build jar file based on pom.xml file)

docker build -t learn1988/blog-service:2.0 . (build a docker image based on docker file config)

docker images (show images)

docker push learn1988/blog-service:2.0 (push the docker image to docker hub)

kubectl apply -f k8s-blog-config.yaml (tell k8s to synchronize the current state of your cluster with the "desired state" defined in that specific YAML file)

3> create a domain to access the appl's

sudo vim /etc/hosts

127.0.0.1       startit.com

save it

4> ingress-controller

create a spring boot ingress-controller projects

brew install helm (install helm)

create a ingress.yaml file

kubectl get pods -n ingress-nginx

if the above cmd is giving No resources found in ingress-nginx namespace. Then execute the below cmd

helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx

helm repo update

helm install my-ingress ingress-nginx/ingress-nginx --namespace ingress-nginx --create-namespace

kubectl get pods -n ingress-nginx

kubectl apply -f ingress.yaml

kubectl get pod -n ingress-nginx

kubectl get service -n ingress-nginx

kubectl get deployment -n ingress-nginx

----


kubectl get ingress --all-namespaces || true

kubectl get svc --all-namespaces || true

kubectl get pods --all-namespaces || true

kubectl apply -f ingress.yaml

kubectl describe ingress microservices-ingress || true

kubectl describe svc course-service

kubectl describe svc blog-service

kubectl get endpoints course-service -o wide || true

kubectl get endpoints blog-service -o wide || true


ingress-resources % # try curl'ing the ingress controller using Host header to route to services
quote> curl -sS -D - -o /dev/null -H "Host: startit.com" http://localhost/course/ || true
quote> curl -sS -D - -o /dev/null -H "Host: startit.com" http://localhost/blog/ || true
quote> kubectl get pods -n ingress-nginx -o wide
quote> POD=$(kubectl get pods -n ingress-nginx -o name | head -n1)
quote> kubectl logs -n ingress-nginx ${POD} --tail=200 || true
quote> # Try curling ingress via localhost with Host header and show detailed output
quote> curl -v -H "Host: startit.com" http://localhost/course/ || true
quote> curl -v -H "Host: startit.com" http://127.0.0.1/course/ || true
quote> # Also try using nodePort on localhost (31478) if present
quote> kubectl get svc -n ingress-nginx my-ingress-ingress-nginx-controller -o jsonpath='{.spec.ports[0].nodePort}' || true
quote> NODEPORT=$(kubectl get svc -n ingress-nginx my-ingress-ingress-nginx-controller -o jsonpath='{.spec.ports[0].nodePort}')
quote> curl -v -H "Host: startit.com" http://localhost:${NODEPORT}/course/ || true
quote> kubectl get svc -n ingress-nginx my-ingress-ingress-nginx-controller -o yaml
quote> kubectl get pods -n ingress-nginx -o wide
quote> POD=$(kubectl get pods -n ingress-nginx -o name | head -n1 | sed 's@pod/@@')
quote> echo "Using pod: ${POD}"
quote> kubectl logs -n ingress-nginx ${POD} --tail=200 || true
quote> # Curl the ingress controller via nodePort 31478 (mapped to port 80) with Host header
quote> curl -v -H "Host: startit.com" http://localhost:31478/course/  || true
quote> curl -v -H "Host: startit.com" http://localhost:31478/blog/  || true
quote> kubectl get ingressclass || true
quote> curl -i -H "Host: startit.com" http://localhost:31478/course/ --max-time 10 || true
