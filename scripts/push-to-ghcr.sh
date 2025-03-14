set -u # or set -o nounset
: "$VERSION"
: "$ACCESS_TOKEN"

echo $ACCESS_TOKEN | docker login  ghcr.io --username hbahramian --password-stdin
docker push ghcr.io/hbahramian/prime-service:$VERSION
