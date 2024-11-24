#
# Deploys the microservice to Kubernetes.
#
# Assumes the image has already been built and published to the container registry.
#
# Environment variables:
#
#   CONTAINER_REGISTRY - The hostname of your container registry.
#   VERSION - The version number of the image to deploy.
#
# Usage:
#
#   ./deploy.sh
#

set -u # or set -o nounset
: "$CONTAINER_REGISTRY"
: "$VERSION"

envsubst < ./scripts/kubernetes/postgres-service.yaml | kubectl delete -f -
envsubst < ./scripts/kubernetes/postgres-deployment.yaml | kubectl delete -f -
envsubst < ./scripts/kubernetes/postgres-storage.yaml | kubectl delete -f -

envsubst < ./scripts/kubernetes/deploy.yaml | kubectl delete -f -

envsubst < ./scripts/kubernetes/postgres-storage.yaml | kubectl apply -f -
envsubst < ./scripts/kubernetes/postgres-deployment.yaml | kubectl apply -f -
envsubst < ./scripts/kubernetes/postgres-service.yaml | kubectl apply -f -
envsubst < ./scripts/kubernetes/deploy.yaml | kubectl apply -f -