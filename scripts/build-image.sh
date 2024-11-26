set -u # or set -o nounset
: "$VERSION"

docker build -t ghcr.io/hbahramian/prime-service:$VERSION --file ./Dockerfile .
