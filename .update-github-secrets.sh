#!/bin/bash

# Exit on error
set -e

# Check for required tools
if ! command -v gh &> /dev/null; then
  echo "Error: GitHub CLI ('gh') is not installed. Please install it before running this script."
  exit 1
fi

# Check for required arguments
if [ "$#" -ne 3 ]; then
  echo "Usage: $0 <owner/repo> <secret_name> <secret_value>"
  echo "Example: $0 my-org/my-repo MY_SECRET 'new-secret-value'"
  exit 1
fi

# Script arguments
REPO=$1           # Repository in the format owner/repo
SECRET_NAME=$2    # Name of the secret to update
SECRET_VALUE=$3   # Value of the secret to set

# Check GitHub CLI authentication
if ! gh auth status &> /dev/null; then
  echo "Error: Not authenticated to GitHub. Run 'gh auth login' to authenticate."
  exit 1
fi

# Update the secret
echo "Updating secret '$SECRET_NAME' for repository '$REPO'..."
echo -n "$SECRET_VALUE" | gh secret set "$SECRET_NAME" -R "$REPO"

# Verify the update
if gh secret list -R "$REPO" | grep -q "$SECRET_NAME"; then
  echo "Secret '$SECRET_NAME' updated successfully."
else
  echo "Error: Failed to update the secret."
  exit 1
fi
