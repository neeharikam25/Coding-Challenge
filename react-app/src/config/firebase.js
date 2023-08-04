// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries
import {getAuth} from "firebase/auth"
import {getFirestore} from "firebase/firestore"

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyDl_NAMv8tTAixor8eilzofDkVzdJvMuAk",
  authDomain: "codingchallenge-d04df.firebaseapp.com",
  projectId: "codingchallenge-d04df",
  storageBucket: "codingchallenge-d04df.appspot.com",
  messagingSenderId: "1095925214503",
  appId: "1:1095925214503:web:94e40959e31a5a2de70d02",
  measurementId: "G-3B3R0X3P4Y"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);
const db=getFirestore(app)
export const auth=getAuth(app)

export  default app;