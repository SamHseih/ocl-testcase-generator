:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_ThreeDimVarArray_sub_DC_Path_11_BDPath_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2, Self_dim3],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2, Arg_dim3],
Result = [Result_data,Result_dimensionSizes],Result_dimensionSizes = [Result_dim1, Result_dim2, Result_dim3],

decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),
decl_Array(Result_data,Result_dimensionSizes),

[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(3,Self_dimensionSizes,Var_2147046752),
nth1(2,Self_dimensionSizes,Var_1262773598),
nth1(1,Self_dimensionSizes,Var_715378067),
(((Var_715378067 #> 0) , (Var_1262773598 #> 0)) , (Var_2147046752 #> 0)),
nth1(3,Arg_dimensionSizes,Var_1702940637),
nth1(3,Self_dimensionSizes,Var_1782580546),
nth1(2,Arg_dimensionSizes,Var_836220863),
nth1(2,Self_dimensionSizes,Var_820914198),
nth1(1,Arg_dimensionSizes,Var_1327536153),
nth1(1,Self_dimensionSizes,Var_1031061344),
length(Arg_dimensionSizes,Var_365181913),
length(Self_dimensionSizes,Var_1105423942),
((((Var_1105423942 #= Var_365181913) , (Var_1031061344 #= Var_1327536153)) , (Var_820914198 #= Var_836220863)) , (Var_1782580546 #= Var_1702940637)),
nth1(3,Result_dimensionSizes,Var_1668016508),
nth1(3,Self_dimensionSizes,Var_1058634310),
nth1(2,Result_dimensionSizes,Var_1028780142),
nth1(2,Self_dimensionSizes,Var_1209702763),
nth1(1,Result_dimensionSizes,Var_1997859171),
nth1(1,Self_dimensionSizes,Var_501107890),
length(Result_dimensionSizes,Var_58940486),
length(Self_dimensionSizes,Var_551479935),
((((Var_551479935 #= Var_58940486) , (Var_501107890 #= Var_1997859171)) , (Var_1209702763 #= Var_1028780142)) , (Var_1058634310 #= Var_1668016508)),
nth1(1,Arg_dimensionSizes,Var_404214852),
(D1 = Var_404214852),
nth1(2,Arg_dimensionSizes,Var_1354003114),
(D2 = Var_1354003114),
nth1(3,Arg_dimensionSizes,Var_388357135),
(D3 = Var_388357135),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< D1 - 1+ 1),
sequencetoList(1,D1,List_957465255),nth1(Idx0,List_957465255,Var_957465255),(It = Var_957465255),
(Acc2 = true),
(Idx1 #= 1),
(Idx1 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_787738361),nth1(Idx1,List_787738361,Var_787738361),(It2 = Var_787738361),
(Acc3 = true),
(Idx2 #= 1),
(Idx2 #=< D3 - 1+ 1),
sequencetoList(1,D3,List_1201484275),nth1(Idx2,List_1201484275,Var_1201484275),(It3 = Var_1201484275),
getArrayElement(Arg_data,[It,It2,It3],Var_1021436681_1),getArrayElement(Self_data,[It,It2,It3],Var_1904253191_1),getArrayElement(Result_data,[It,It2,It3],Var_1645547422_1),(Var_1645547422_1 #= (Var_1904253191_1-Var_1021436681_1)),
(Idx2_1 #= (Idx2+1)),
(Idx2_1 #=< D3 - 1+ 1),
sequencetoList(1,D3,List_1201484275),nth1(Idx2_1,List_1201484275,Var_1201484275_1),(It3_1 = Var_1201484275_1),
getArrayElement(Arg_data,[It,It2,It3_1],Var_1021436681_2),getArrayElement(Self_data,[It,It2,It3_1],Var_1904253191_2),getArrayElement(Result_data,[It,It2,It3_1],Var_1645547422_2),(Var_1645547422_2 #= (Var_1904253191_2-Var_1021436681_2)),
(Idx2_2 #= (Idx2_1+1)),
(Idx2_2 #> D3 - 1+ 1),
(Idx1_1 #= (Idx1+1)),
(Idx1_1 #> D2 - 1+ 1),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #> D1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
