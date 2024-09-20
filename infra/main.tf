terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.66.0"
    }
  }

  required_version = "~> 1.9.5"
}

provider "helm" {
  kubernetes {
    host                   = aws_eks_cluster.techchallenge_cluster.endpoint
    cluster_ca_certificate = base64decode(aws_eks_cluster.techchallenge_cluster.certificate_authority[0].data)
    exec {
      api_version = "client.authentication.k8s.io/v1beta1"
      args        = ["eks", "get-token", "--cluster-name", var.cluster_name, "--output", "json"]
      command     = "aws"
    }
  }
}

provider "aws" {
  region = var.aws_region
}

resource "helm_release" "app" {
  name             = var.app_name
  repository       = file("${path.module}/helm/backend")
  chart            = var.app_name
  namespace        = var.app_name
  create_namespace = true
}