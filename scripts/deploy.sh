
set -u # or set -o nounset
: "$CONTAINER_REGISTRY"
: "$VERSION"
: "$SPRING_DATASOURCE_URL"
: "$SPRING_DATASOURCE_UN"
: "$SPRING_DATASOURCE_PW"

envsubst < ./scripts/kubernetes/deploy.yaml | kubectl apply -f -